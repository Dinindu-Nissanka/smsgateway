package com.dropwizard.smsautomator.handler;

import com.dropwizard.smsautomator.AppConfiguration;
import com.dropwizard.smsautomator.request.SMSReceiptRequest;
import com.dropwizard.smsautomator.request.nexmorequest.NexmoRequest;
import com.dropwizard.smsautomator.response.DeliveryInfo;
import com.dropwizard.smsautomator.response.DeliveryInfoList;
import com.dropwizard.smsautomator.response.OutboundSMSMessageRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import static javax.ws.rs.core.HttpHeaders.USER_AGENT;

/**
 * Created by dinindu on 5/30/17.
 */
public class SMSRequestHandler {

    private final AppConfiguration configuration;

    public SMSRequestHandler(AppConfiguration configuration) {
        this.configuration = configuration;
    }

    public OutboundSMSMessageRequest handleSMSRequest(SMSReceiptRequest smsReceiptRequest) throws JsonProcessingException, UnsupportedEncodingException {

        DeliveryInfoList deliveryInfoList = this.sendSMSToMultipleAddresses(smsReceiptRequest.getOutboundSMSMessageRequest().getAddress(),smsReceiptRequest.getOutboundSMSMessageRequest().getOutboundSMSTextMessage().getMessage());

        OutboundSMSMessageRequest outboundSMSMessageRequest = new OutboundSMSMessageRequest();
        outboundSMSMessageRequest.setAddress(smsReceiptRequest.getOutboundSMSMessageRequest().getAddress());
        outboundSMSMessageRequest.setClientCorrelator(smsReceiptRequest.getOutboundSMSMessageRequest().getClientCorrelator());
        outboundSMSMessageRequest.setDeliveryInfoList(deliveryInfoList);
        outboundSMSMessageRequest.setOutboundSMSTextMessage(smsReceiptRequest.getOutboundSMSMessageRequest().getOutboundSMSTextMessage());
        outboundSMSMessageRequest.setReceiptRequest(smsReceiptRequest.getOutboundSMSMessageRequest().getReceiptRequest());
        outboundSMSMessageRequest.setResourceURL("http://localhost:8181/smsmessaging/v1_2/outbound/tel:+7878/requests/505812");
        outboundSMSMessageRequest.setSenderAddress(smsReceiptRequest.getOutboundSMSMessageRequest().getSenderAddress());
        outboundSMSMessageRequest.setSenderName(smsReceiptRequest.getOutboundSMSMessageRequest().getSenderName());

        return outboundSMSMessageRequest;
    }

    public DeliveryInfoList sendSMSToMultipleAddresses(List<String> addresses, String message) throws UnsupportedEncodingException, JsonProcessingException {
        DeliveryInfoList deliveryInfoList = new DeliveryInfoList();
        List<DeliveryInfo> deliveryList = new ArrayList<DeliveryInfo>();

        for (int i = 0; i < addresses.size(); i++) {
            DeliveryInfo deliveryInfo = new DeliveryInfo();
            deliveryInfo.setAddress(addresses.get(i));
            String deliveryStatus = sendSMS(addresses.get(i),message);
            deliveryInfo.setDeliveryStatus(deliveryStatus);
            deliveryList.add(deliveryInfo);
        }
        deliveryInfoList.setDeliveryInfo(deliveryList);
        return deliveryInfoList;
    }

    public String sendSMS(String address, String message) throws JsonProcessingException, UnsupportedEncodingException {
        String msisdn = address.split("\\+")[1];
        String url = this.configuration.getNexmoGateway();

        HttpClient client = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost(url);

        // add header
        post.setHeader("User-Agent", USER_AGENT);
        post.setHeader("Content-Type","application/json");

        NexmoRequest nexmoRequest = configuration.getSmsRequest().getNexmoRequest();
        nexmoRequest.setTo(msisdn);
        nexmoRequest.setText(message);

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(nexmoRequest);
        StringEntity entity = new StringEntity(json);
        post.setEntity(entity);

        HttpResponse response = null;

        try {
            response = client.execute(post);
            String responseEntity = EntityUtils.toString(response.getEntity());

            JSONObject obj = new JSONObject(responseEntity);
            String deliveryStatus = obj.getJSONArray("messages").getJSONObject(0).getString("status");

            if(deliveryStatus.equals("0"))
                return "Message delivered to the recipient";
            else
                return "Message was not delivered";
        } catch (IOException e) {
            e.printStackTrace();
            return "Message was not delivered";
        }

    }
}

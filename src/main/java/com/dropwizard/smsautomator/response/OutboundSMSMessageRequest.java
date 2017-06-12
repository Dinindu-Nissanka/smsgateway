
package com.dropwizard.smsautomator.response;

/**
 * Created by dinindu on 5/30/17.
 */

import java.util.List;

import com.dropwizard.smsautomator.request.OutboundSMSTextMessage;
import com.dropwizard.smsautomator.request.ReceiptRequest;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "address",
    "outboundSMSTextMessage",
    "clientCorrelator",
    "receiptRequest",
    "deliveryInfoList",
    "senderAddress",
    "senderName",
    "resourceURL"
})
public class OutboundSMSMessageRequest {

    @JsonProperty("address")
    private List<String> address = null;
    @JsonProperty("outboundSMSTextMessage")
    private OutboundSMSTextMessage outboundSMSTextMessage;
    @JsonProperty("clientCorrelator")
    private String clientCorrelator;
    @JsonProperty("receiptRequest")
    private ReceiptRequest receiptRequest;
    @JsonProperty("deliveryInfoList")
    private DeliveryInfoList deliveryInfoList;
    @JsonProperty("senderAddress")
    private String senderAddress;
    @JsonProperty("senderName")
    private String senderName;
    @JsonProperty("resourceURL")
    private String resourceURL;

    @JsonProperty("address")
    public List<String> getAddress() {
        return address;
    }

    @JsonProperty("address")
    public void setAddress(List<String> address) {
        this.address = address;
    }

    @JsonProperty("outboundSMSTextMessage")
    public OutboundSMSTextMessage getOutboundSMSTextMessage() {
        return outboundSMSTextMessage;
    }

    @JsonProperty("outboundSMSTextMessage")
    public void setOutboundSMSTextMessage(OutboundSMSTextMessage outboundSMSTextMessage) {
        this.outboundSMSTextMessage = outboundSMSTextMessage;
    }

    @JsonProperty("clientCorrelator")
    public String getClientCorrelator() {
        return clientCorrelator;
    }

    @JsonProperty("clientCorrelator")
    public void setClientCorrelator(String clientCorrelator) {
        this.clientCorrelator = clientCorrelator;
    }

    @JsonProperty("receiptRequest")
    public ReceiptRequest getReceiptRequest() {
        return receiptRequest;
    }

    @JsonProperty("receiptRequest")
    public void setReceiptRequest(ReceiptRequest receiptRequest) {
        this.receiptRequest = receiptRequest;
    }

    @JsonProperty("deliveryInfoList")
    public DeliveryInfoList getDeliveryInfoList() {
        return deliveryInfoList;
    }

    @JsonProperty("deliveryInfoList")
    public void setDeliveryInfoList(DeliveryInfoList deliveryInfoList) {
        this.deliveryInfoList = deliveryInfoList;
    }

    @JsonProperty("senderAddress")
    public String getSenderAddress() {
        return senderAddress;
    }

    @JsonProperty("senderAddress")
    public void setSenderAddress(String senderAddress) {
        this.senderAddress = senderAddress;
    }

    @JsonProperty("senderName")
    public String getSenderName() {
        return senderName;
    }

    @JsonProperty("senderName")
    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    @JsonProperty("resourceURL")
    public String getResourceURL() {
        return resourceURL;
    }

    @JsonProperty("resourceURL")
    public void setResourceURL(String resourceURL) {
        this.resourceURL = resourceURL;
    }

}

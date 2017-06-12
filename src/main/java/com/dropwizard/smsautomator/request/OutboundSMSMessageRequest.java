package com.dropwizard.smsautomator.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by dinindu on 5/29/17.
 */
public class OutboundSMSMessageRequest {

    @JsonProperty
    private List<String> address;

    @JsonProperty
    private String senderAddress;

    @JsonProperty
    private OutboundSMSTextMessage outboundOutboundSMSTextMessage;

    @JsonProperty
    private String clientCorrelator;

    @JsonProperty
    private String senderName;

    @JsonProperty
    private ReceiptRequest receiptRequest;


    public List<String> getAddress() {
        return address;
    }

    public void setAddress(List<String> address) {
        this.address = address;
    }

    public String getSenderAddress() {
        return senderAddress;
    }

    public void setSenderAddress(String senderAddress) {
        this.senderAddress = senderAddress;
    }

    public OutboundSMSTextMessage getOutboundOutboundSMSTextMessage() {
        return outboundOutboundSMSTextMessage;
    }

    public void setOutboundOutboundSMSTextMessage(OutboundSMSTextMessage outboundOutboundSMSTextMessage) {
        this.outboundOutboundSMSTextMessage = outboundOutboundSMSTextMessage;
    }

    public String getClientCorrelator() {
        return clientCorrelator;
    }

    public void setClientCorrelator(String clientCorrelator) {
        this.clientCorrelator = clientCorrelator;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public ReceiptRequest getReceiptRequest() {
        return receiptRequest;
    }

    public void setReceiptRequest(ReceiptRequest receiptRequest) {
        this.receiptRequest = receiptRequest;
    }
}

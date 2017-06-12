package com.dropwizard.smsautomator.request;

/**
 * Created by dinindu on 5/30/17.
 */
public class SMSReceiptRequest {

    private OutboundSMSMessageRequest outboundSMSMessageRequest;

    public OutboundSMSMessageRequest getOutboundSMSMessageRequest() {
        return outboundSMSMessageRequest;
    }

    public void setOutboundSMSMessageRequest(OutboundSMSMessageRequest outboundSMSMessageRequest) {
        this.outboundSMSMessageRequest = outboundSMSMessageRequest;
    }
}

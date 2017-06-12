package com.dropwizard.smsautomator.request;

/**
 * Created by dinindu on 5/29/17.
 */
public class OutboundSMSTextMessage {

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private String message;
}

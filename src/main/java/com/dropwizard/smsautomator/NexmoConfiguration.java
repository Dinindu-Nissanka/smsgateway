package com.dropwizard.smsautomator;

import com.dropwizard.smsautomator.request.nexmorequest.NexmoRequest;

/**
 * Created by dinindu on 5/30/17.
 */
public class NexmoConfiguration {

    public NexmoRequest getNexmoRequest() {
        return nexmoRequest;
    }

    public void setNexmoRequest(NexmoRequest nexmoRequest) {
        this.nexmoRequest = nexmoRequest;
    }

    private NexmoRequest nexmoRequest;


}

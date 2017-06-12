package com.dropwizard.smsautomator;

import io.dropwizard.Configuration;

/**
 * Created by dinindu on 5/30/17.
 */
public class AppConfiguration extends Configuration {

    private String nexmoGateway;

    private NexmoConfiguration smsRequest;


    public NexmoConfiguration getSmsRequest() {
        return smsRequest;
    }

    public void setSmsRequest(NexmoConfiguration smsRequest) {
        this.smsRequest = smsRequest;
    }

    public String getNexmoGateway() {
        return nexmoGateway;
    }

    public void setNexmoGateway(String nexmoGateway) {
        this.nexmoGateway = nexmoGateway;
    }
}

package com.dropwizard.smsautomator.resources;

import com.dropwizard.smsautomator.AppConfiguration;
import com.dropwizard.smsautomator.handler.SMSRequestHandler;
import com.dropwizard.smsautomator.request.SMSReceiptRequest;
import com.dropwizard.smsautomator.response.OutboundSMSMessageRequest;
import org.apache.http.HttpResponse;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;

/**
 * Created by dinindu on 5/30/17.
 */


@Path("/sendsms")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SMSSenderResource {

    private final AppConfiguration configuration;

    public SMSSenderResource(AppConfiguration configuration) {
        this.configuration = configuration;
    }

    @POST
    public Response sendSMS(SMSReceiptRequest SMSReceiptRequest) throws IOException {

        SMSRequestHandler handler = new SMSRequestHandler(configuration);
        OutboundSMSMessageRequest outboundSMSMessageRequest = handler.handleSMSRequest(SMSReceiptRequest);
        return Response
                .ok(outboundSMSMessageRequest)
                .build();
    }
}

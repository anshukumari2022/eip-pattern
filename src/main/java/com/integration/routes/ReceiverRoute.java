package com.integration.routes;

import org.apache.camel.builder.RouteBuilder;

// @Component
public class ReceiverRoute extends RouteBuilder {

    @Override
    public void configure() {
        from("activemq:split-queue").to("log:message received from active mq");
    }
}

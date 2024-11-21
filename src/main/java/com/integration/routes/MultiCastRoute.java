package com.integration.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class MultiCastRoute extends RouteBuilder {

    @Override
    public void configure() {
        from("timer:multicast?period=10000")
                .transform()
                .constant("Test message")
                .multicast() // send message to more than one endpoint : multicast message to all its child output, ch
                // processor or destination gets the copy of original message to avoid processor
                // interference with each other
                .to("log:message1", "log:message2", "log:message3");
    }
}

package com.integration.routes;

import org.apache.camel.builder.RouteBuilder;

// @Component
public class SplitToQueueRoute extends RouteBuilder {

    @Override
    public void configure() {
        from("file:files/csv")
                .unmarshal()
                .csv() // process as csv
                .split(body()) // only this split as a single file or with csv split each line of csv
                .to("activemq:split-queue");
    }
}

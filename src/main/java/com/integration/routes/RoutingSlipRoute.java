package com.integration.routes;

import org.apache.camel.builder.RouteBuilder;

// @Component
public class RoutingSlipRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        String routingSlip = "direct:endpoint1, direct:endpoint5"; // dynamic decide for routing
        from("timer:routingSlip?period=10000")
                .transform()
                .constant("Test message")
                .routingSlip(simple(routingSlip));

        from("direct:endpoint1").to("log:endpoint1");

        from("direct:endpoint5").to("log:endpoint5");
    }
}

package com.integration.routes;

import com.integration.model.User;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.stereotype.Component;

//@Component
public class AggregationRoute extends RouteBuilder {
    @Override
    public void configure() {
        from("file:files/json")
                .unmarshal()
                .json(JsonLibrary.Jackson, User.class)
                .aggregate(simple("${body.username}"), new ArrayListAggregationStrategy())
                .completionSize(3)
                .to("log:aggregate-json");
    }
}

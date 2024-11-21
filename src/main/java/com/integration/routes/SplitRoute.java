package com.integration.routes;

import org.apache.camel.builder.RouteBuilder;

// @Component
public class SplitRoute extends RouteBuilder {

    @Override
    public void configure() {
        from("file:files/csv")
                .unmarshal()
                .csv() // process as csv
                .split(body()) // only this split as a single file or with csv split each line of csv
                .to("log:split-body");

        //        from("file:files/csv")
        //                .convertBodyTo(String.class)
        //                .split(body(), ",")
        ////                .split(method(splitter)) create custom splitter and pass the bean of it
        //                .to("log:split-body");
    }
}

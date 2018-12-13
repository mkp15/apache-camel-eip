package com.pandma.camel.integration.router;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQRouter extends RouteBuilder {

    public static final String ROUTE_NAME = "TIMER_ROUTE";

    @Override
    public void configure() throws Exception {

        from("timer:hello?period=1000")
                .transform(simple("Random number ${random(0,100)}"))
                .to("rabbitmq:myexchange?connectionFactory=#rabbitConnectionFactory");

        from("rabbitmq:myexchange")
                .log("From RabbitMQ: ${body}");
    }
}

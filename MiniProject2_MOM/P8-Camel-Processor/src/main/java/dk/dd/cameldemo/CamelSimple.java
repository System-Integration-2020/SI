package dk.dd.cameldemo;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class CamelSimple extends RouteBuilder
{
    @Override
    public void configure() throws Exception
    {
        from("rabbitmq:localhost:15672/message-exchange?username=guest&password=guest&autoDelete=false&routingKey=message-key&queue=message").to("file:src/main/resources/Messages").end();

    }

}

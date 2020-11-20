package rabbitmq;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Send {
    private final static String QUEUE_NAME = "hello";

    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
                //declare queue:
                    //Declaring a queue is idempotent - it will only be created if it doesn't exist already.
                channel.queueDeclare(QUEUE_NAME, false, false, false, null);
                String message = "Hello World";
                channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
                System.out.println(" [x] sent '" + message + "'");
        }

    }
}
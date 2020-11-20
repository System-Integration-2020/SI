package rabbitmq;


import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.concurrent.TimeoutException;

public class Receive {
    public final static String QUEUE_NAME = "hello";

    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare("QUEUE_NAME", false, false, false, null);
        System.out.println("[*] Waiting for messages. To exit press ctrl+C");

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {              //We're about to tell the server to deliver us the messages from the queue. Since it will push us messages asynchronously, we provide a callback in the form of an object that will buffer the messages until we're ready to use them. That is what a DeliverCallback subclass does.
            String message = new String(delivery.getBody(), "UTF-8");
            System.out.println("[x] Received '" + message + "'");
        };
        channel.basicConsume(QUEUE_NAME, true, deliverCallback, consumerTag -> { });
    }
}

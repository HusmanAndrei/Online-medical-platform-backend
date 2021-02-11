package ro.tuc.ds2020.rabbit;

import ro.tuc.ds2020.entities.Activity;
import com.google.gson.Gson;
import com.rabbitmq.client.*;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import ro.tuc.ds2020.services.util.IActivityService;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.TimeoutException;
@Component
@RequiredArgsConstructor
public class Consumer {
    private final static Gson gson = new Gson();
    private final IActivityService iActivityService;

    @Bean
    public void Consumer () throws IOException, NoSuchAlgorithmException, KeyManagementException, URISyntaxException, TimeoutException {

        ConnectionFactory factory = new ConnectionFactory();
        String uri = "amqps://ujrahjwg:feP0wmEVfFj9ysqkmh3jIcqR_5ecgReF@sparrow.rmq.cloudamqp.com/ujrahjwg";
        factory.setUri(uri);


        factory.setConnectionTimeout(30000);
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare("activities", false, false, false, null);
        System.out.println(" [*] Waiting for messages");
        com.rabbitmq.client.Consumer consumer = new DefaultConsumer(channel) {


            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body);
                System.out.println("Received: " + message);
                String patientActivity = new String(body, StandardCharsets.UTF_8);
                Activity activity = gson.fromJson(patientActivity, Activity.class);
                iActivityService.processActivity(activity);
            }

            @Override
            public void handleConsumeOk(String consumerTag) {
                System.out.println("Handled consumer OK!");
            }
        };
        channel.basicConsume("activities", true, consumer);
    }
}


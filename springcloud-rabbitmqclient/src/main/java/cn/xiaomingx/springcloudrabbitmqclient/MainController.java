package cn.xiaomingx.springcloudrabbitmqclient;

import com.rabbitmq.client.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static org.springframework.amqp.rabbit.core.RabbitAdmin.QUEUE_NAME;

/**
 * @author: Ming
 * @PROJECT: springcloudlearning
 * @Package cn.xiaomingx.springcloudrabbitmqclient
 * @date 2018/5/25 15:10
 * @Description: ${todo}
 */
@RestController
public class MainController {
    @RequestMapping("/hello")
    public String hello(){
        return "Hello Ming";
    }
    @RequestMapping("/reciever")
    public String reciever() throws Exception{
        /* 建立连接 */
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("52.193.160.92");
        factory.setUsername("guest");
        factory.setPassword("guest");
        factory.setPort(5672);
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        /* 声明要连接的队列 */
        channel.queueDeclare("ClmClose", true, false, false, null);
        System.out.println("等待消息产生：");

        /* 创建消费者对象，用于读取消息 */
        StringBuilder msg = new StringBuilder();
        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body)
                    throws IOException {
                String message = new String(body, "UTF-8");
                System.out.println("Message:"+message);
                msg.append(message);
            }
        };
        channel.basicConsume("ClmClose", true, consumer);

        /* 读取队列，并且阻塞，即在读到消息之前在这里阻塞，直到等到消息，完成消息的阅读后，继续阻塞循环 */

        return msg.toString();
    }
}

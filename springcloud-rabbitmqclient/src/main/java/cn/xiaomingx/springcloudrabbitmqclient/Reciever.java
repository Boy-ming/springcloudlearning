package cn.xiaomingx.springcloudrabbitmqclient;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

/**
 * @author: Ming
 * @PROJECT: springcloudlearning
 * @Package cn.xiaomingx.springcloudrabbitmqclient
 * @date 2018/5/25 15:05
 * @Description: ${todo}
 */
@Component
@EnableScheduling
public class Reciever {
    @RabbitListener(queues = "hello", containerFactory = "rabbitListenerContainerFactory")
    @RabbitHandler
    public void process(String order){
        System.out.println("Myreciever:"+order);
    }

}

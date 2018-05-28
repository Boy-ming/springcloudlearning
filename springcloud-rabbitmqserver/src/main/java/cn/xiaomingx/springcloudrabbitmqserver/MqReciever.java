package cn.xiaomingx.springcloudrabbitmqserver;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

/**
 * @author: Ming
 * @PROJECT: springcloudlearning
 * @Package cn.xiaomingx.springcloudrabbitmqserver
 * @date 2018/5/25 14:48
 * @Description: ${todo}
 */
@Component
@EnableScheduling
public class MqReciever {
    //@RabbitHandler
    //@RabbitListener(queues = "hello",containerFactory = "rabbitListenerContainerFactory")
    //public void process(@Payload String order){
//        System.out.println("Myreciever:"+order);
//    }
}

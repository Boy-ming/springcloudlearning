package cn.xiaomingx.springcloudrabbitmqserver;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author: Ming
 * @PROJECT: springcloudlearning
 * @Package cn.xiaomingx.springcloudrabbitmqserver
 * @date 2018/5/25 14:18
 * @Description: ${todo}
 */
@Component
//@RabbitListener(queues = "hello")
public class Reciver {

    @RabbitHandler
    public void process(String hello) {
        System.out.println("Receiver : " + hello);
    }

}
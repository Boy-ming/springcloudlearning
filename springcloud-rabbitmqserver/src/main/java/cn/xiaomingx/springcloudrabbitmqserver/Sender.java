package cn.xiaomingx.springcloudrabbitmqserver;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Date;

/**
 * @author: Ming
 * @PROJECT: springcloudlearning
 * @Package cn.xiaomingx.springcloudrabbitmqserver
 * @date 2018/5/25 14:10
 * @Description: ${todo}
 */
@Component
public class Sender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(String context) {
        //String context = "hello " + new Date();
        System.out.println("Sender : " + context);
        this.rabbitTemplate.convertAndSend("hello", context);
    }

}
package cn.xiaomingx.springcloudrabbitmqserver;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Ming
 * @PROJECT: springcloudlearning
 * @Package cn.xiaomingx.springcloudrabbitmqserver
 * @date 2018/5/25 14:57
 * @Description: ${todo}
 */
@RestController

public class MainController {
    @Autowired
    private Sender sender;
    @RequestMapping("send/{msg}")
    public String sendMsg(@PathVariable String msg){
        System.out.println("Msg:"+msg);
        for (int i = 0; i < 1000; i++) {
            sender.send(msg+i);
        }
        return msg;
    }
    @RequestMapping("/send2/{msg}")
    public String send2(@PathVariable String msg) throws Exception{
        String MQname ="ClmClose";
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("52.193.160.92");
        factory.setUsername("guest");
        factory.setPassword("guest");
        factory.setPort(5672);
        Connection connection;
            connection = factory.newConnection();
            Channel channel = connection.createChannel();
            channel.queueDeclare(MQname, true, false, false, null);
            channel.basicPublish("", MQname, null, msg.getBytes("UTF-8"));
            channel.close();
            connection.close();

        return null;
    }
}

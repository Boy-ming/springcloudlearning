package cn.xiaomingx.springcloudconfigserver;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

@SpringBootApplication
@EnableConfigServer
@EnableEurekaClient
@RestController
public class SpringcloudConfigserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudConfigserverApplication.class, args);
	}
	@RequestMapping("/rabbit")
	public String rabbit(@RequestParam String msg) throws IOException, TimeoutException {
		String QUEUE_NAME = "hello";
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();
		channel.queueDeclare(QUEUE_NAME, false, false, false, null);
		String message = msg;
		channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
		System.out.println(" [x] Sent '" + message + "'");
		channel.close();
		connection.close();
		return "ok";
	}
}

package cn.xiaomingx.springcloudzipkinserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zipkin.server.EnableZipkinServer;


@SpringBootApplication
@EnableZipkinServer
public class SpringcloudZipkinserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudZipkinserverApplication.class, args);
	}
}

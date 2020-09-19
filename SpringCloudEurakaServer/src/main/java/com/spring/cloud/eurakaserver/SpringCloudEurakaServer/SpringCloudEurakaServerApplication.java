package com.spring.cloud.eurakaserver.SpringCloudEurakaServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SpringCloudEurakaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudEurakaServerApplication.class, args);
	}

}

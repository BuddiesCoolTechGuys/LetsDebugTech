package com.spring.cloud.eurakaclient.login;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.spring.cloud.eurakaclient.login.config.UserRibbonClientConfig;

@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "CART-SERVICE", configuration = UserRibbonClientConfig.class)
public class EurekaClientLoginApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaClientLoginApplication.class, args);
	}

	/**
	 * Object creation for RestTemplate
	 * Annotation to mark a RestTemplate bean to be configured to use a LoadBalancerClient
	 * @return
	 */
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}

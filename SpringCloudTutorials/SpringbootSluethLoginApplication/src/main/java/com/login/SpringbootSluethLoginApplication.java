package com.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import brave.sampler.Sampler;

@SpringBootApplication
public class SpringbootSluethLoginApplication {

	private final static Logger LOGGER = LoggerFactory.getLogger(SpringbootSluethLoginApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringbootSluethLoginApplication.class, args);
		LOGGER.info("Springboot slueth zipkin Login Microservice1 started successfully.");
	}

	// Configuring the restTemplate object.
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	// Introducing sampling as in distributed tracing logging is very high
	// There are two types of sampler - ALWAYS_SAMPLE or NEVER_SAMPLER.
	// Helps to trace all the request
	@Bean
	public Sampler sampler() {
		return Sampler.ALWAYS_SAMPLE;
	}
}

package com.order;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import brave.sampler.Sampler;

@SpringBootApplication
public class SpringbootSluethOrderApplication {

	private final static Logger LOGGER = LoggerFactory.getLogger(SpringbootSluethOrderApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringbootSluethOrderApplication.class, args);
		LOGGER.info("Springboot slueth zipkin microservice2 started successfully.");
	}

	// Configuring the restTemplate object.
	// Ideally should be in the Configuration class. We are avoiding the extra classes for the simplicity of this tutorial.
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	// Introducing sampling as in distributed tracing logging is very high
	// There are two types of sampler - ALWAYS_SAMPLE or NEVER_SAMPLER.
	@Bean
	public Sampler sampler() {
		return Sampler.ALWAYS_SAMPLE;
	}
}

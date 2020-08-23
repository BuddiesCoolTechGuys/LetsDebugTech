package com.login.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value = "/microservice1")
public class LoginController {

	private final static Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	private RestTemplate restTemplate;

	/*
	 * Resource URL - http://localhost:9001/microservice1
	 */
	@GetMapping
	public String welcome() {
		LOGGER.info("Inside microservice1 welcome() method.");

		// Hitting the microservice2 from microservice1 to fetch the response.
		// For simplicity we are directly configuring the URL earlier.
		// For production ready applications, it should be populated from the configuration files.
		final String microservice2Url = "http://localhost:9001/microservice2";
		final String response = (String) restTemplate.exchange(microservice2Url, HttpMethod.GET, null, String.class).getBody();

		LOGGER.info("The response received from microservice2= " + response);
		// Returning the response to the user.
		return response;
	}
}

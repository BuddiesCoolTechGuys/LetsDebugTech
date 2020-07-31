package com.spring.cloud.eurakaclient.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value = "login-service")
public class LoginController {

    @Autowired
    private RestTemplate restTemplate;
	
    /**
     * Sample GET method which will communicate with different cart instances
     * @return
     */
	@RequestMapping(value = "/fetchCardDetails", method = RequestMethod.GET)
	public String getCardDetails() {
		
		/**
		 * Actual cart URL -> http://localhost:9001/getcarddetails
		 * But, we are not mention respective client instance IP and PORT details here
		 */
		
		String response = restTemplate.getForObject("http://cart-service/getcarddetails", String.class);
		return response;
	} 
	
}

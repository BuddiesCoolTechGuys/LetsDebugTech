package com.spring.cloud.eurakaclient.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CartController {
	
    /**
     * Cart service
     * @return
     */
	@RequestMapping(value = "/getcarddetails", method = RequestMethod.GET)
	public String getCardDetails() {
		return "Data Successfully Fetched From Cart Instance3";
	} 
	
}

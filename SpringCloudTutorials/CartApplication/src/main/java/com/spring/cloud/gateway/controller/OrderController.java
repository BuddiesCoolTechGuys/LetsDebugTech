package com.spring.cloud.gateway.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "ecommerce")	
public class OrderController {
	
	/**
	 * Sample Get Request Method
	 * @return
	 */
	@RequestMapping(value = "/order/getdata", method = RequestMethod.GET)
	public String getCardDetails() {
		return "You order is successfully placed. Ref.No: 1241212";
	}
}

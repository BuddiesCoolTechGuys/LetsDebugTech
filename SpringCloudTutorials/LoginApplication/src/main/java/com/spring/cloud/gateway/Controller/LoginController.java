package com.spring.cloud.gateway.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "ecommerce")	
public class LoginController {

	/**
	 * Sample Get Request Method
	 * @return
	 */
	@RequestMapping(value = "/login/user", method = RequestMethod.GET)
	public String userLoginValidation() {
		return "You User Details is successfully validated. Welcome to the Application.. ";
	}
}

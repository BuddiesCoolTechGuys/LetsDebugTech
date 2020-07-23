/**
 * 
 */
package com.spring.cloud.config.client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Arjun
 *
 */
@RestController
@RequestMapping(value = "config-client")
public class SpringCloudConfigClientController {

	@Value("${cloud.config.fetch.data}")
	private String property;
	
	/**
	 * Fetch property details from GitHub Using Config Server
	 * 
	 * @param username
	 * @return
	 */
	@RequestMapping(value = "/fetch", method = RequestMethod.GET)
	public String getConfigDetails() {
		return property;
	}
}

package com.xyz.college.CollegeRestAPI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.xyz.college.CollegeRestAPI.model.Student;

@RestController
@RequestMapping(value = "resttemplate")
public class CollegeRestController {

	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping(value = "/fetch", method = RequestMethod.GET)
	public String getStudentInfo() {
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> httpEntity = new HttpEntity<>(httpHeaders);
		ResponseEntity<?> response = restTemplate.exchange("http://localhost:9090/studentrecords/fetch", HttpMethod.GET, httpEntity, String.class);
		return response.getBody().toString();
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String getStudentInfo(@RequestBody Student student) {
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Student> httpEntity = new HttpEntity<Student>(student, httpHeaders);
		return restTemplate.exchange("http://localhost:9090/studentrecords/save", HttpMethod.POST, httpEntity, String.class).getBody();
	}
	
}

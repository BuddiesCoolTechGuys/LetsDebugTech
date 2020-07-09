package com.ctg.restful.controller;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ctg.restful.model.StudentInfo;

@RestController
@RequestMapping(value = "/student")
@Validated
public class RequestValidatorController {
	
	/**
	 * POJO Level Field validation
	 * 
	 * Request -> http://localhost:9003/student/register
	 * Response If -> Validation Success 
	 * Response failure -> Validation Failure - Default
	 * @param id
	 * @param name
	 * @return
	 */
	@RequestMapping(value = "/register", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String registerStudentInfo(@Valid @RequestBody StudentInfo studentInfo) { 
		
		System.out.println("StudentInfo: firstName: "+ studentInfo.getFirstName());
		System.out.println("StudentInfo: lastName "+ studentInfo.getLastName());
		System.out.println("StudentInfo: emailId "+ studentInfo.getEmailAddress());
		System.out.println("StudentInfo: phoneNumber "+ studentInfo.getPhoneNumber());
		System.out.println("StudentInfo: id  "+ studentInfo.getId());
		
		return "Validation Success";
	}

	/**
	 * Query Parameter * Path Parameter Validation
	 * Default = true
	 * http://localhost:9002/student/getId?id=1234&name=CTG
	 * @param id
	 * @param name
	 * @return
	 */
	@RequestMapping(value = "/getId", method = RequestMethod.GET)
	@ResponseBody
	public String getDetails(@RequestParam(value = "id") @Min(3) String id,
			@NotEmpty(message = "name should not be empty") @RequestParam String name) {
		return "Student Id: " + id + " Student Name: " + name;
	}

}

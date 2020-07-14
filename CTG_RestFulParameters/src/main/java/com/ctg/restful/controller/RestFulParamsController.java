package com.ctg.restful.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ctg.restful.model.StudentInfo;

@RestController
@RequestMapping(value = "/student")
public class RestFulParamsController {

	/**
	 * Query Parameter : Condition 1
	 * Default = true
	 * http://localhost:9002/student/getId?id=1234&name=CTG
	 * @param id
	 * @param name
	 * @return
	 */
	@RequestMapping(value = "/getId", method = RequestMethod.GET)
	@ResponseBody
	public String getDetails(@RequestParam(value = "id") String id, @RequestParam String name) { 
		return "Student Id: " + id + " Student Name: " + name;
	}
	
	/**
	 * Query Parameter : Condition 2
	 * 
	 * Request -> http://localhost:9002/student/getIdCheck
	 * Response 1 -> Student is mandatory
	 * Response 2 -> Student is 123
	 * @param id
	 * @param name
	 * @return
	 */
	@RequestMapping(value = "/getIdCheck", method = RequestMethod.GET)
	@ResponseBody
	public String getDetails(@RequestParam(value = "id", required = false) String id) { 
		return "Student id " + (id != null ? "is mandatory" : id);
	}
	
	/**
	 * Query Parameter : Condition 3
	 * 
	 * Request -> http://localhost:9002/student/default
	 * Response -> Student is 12345
	 * @param id
	 * @param name
	 * @return
	 */
	@RequestMapping(value = "/default", method = RequestMethod.GET)
	@ResponseBody
	public String testDefault(@RequestParam(value = "id", defaultValue = "12345") String id) { 
		return "Student id " + id;
	}
	
	/**
	 * Query Parameter : Condition 4
	 * 
	 * Request -> http://localhost:9002/student/list?id=1,2,3
	 * Response -> Student id's are [1,2,3]
	 * @param id
	 * @param name
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	public String getDetails(@RequestParam List<String> id) { 
		return "Student id's are " + id;
	}
	
	/**
	 * Path Parameter : Condition 1
	 * 
	 * Request -> http://localhost:9002/student/getdetails/1234
	 * Response -> Student id is 1234
	 * @param id
	 * @param name
	 * @return
	 */
	@RequestMapping(value = "/getdetails/{id}", method = RequestMethod.GET)
	@ResponseBody
	public String getUriPathDetails(@PathVariable("id") String id) { 
		return "Student id is " + id;
	}
	
	/**
	 * Combine both Path parameter and Query parameter
	 * 
	 * Request -> http://localhost:9002/student/getdetails/1234?name=CTG
	 * Response -> Student id is 1234
	 * @param id
	 * @param name
	 * @return
	 */
	@RequestMapping(value = "/getdetails/{id}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String getDetails(@PathVariable("id") String id, @RequestParam("name") String name, @RequestBody StudentInfo studentInfo) { 
		
		System.out.println("StudentInfo city: "+ studentInfo.getCity());
		System.out.println("StudentInfo: state "+ studentInfo.getState());
		System.out.println("StudentInfo: country "+ studentInfo.getCountry());
		System.out.println("StudentInfo: id  "+ id);
		System.out.println("StudentInfo: name "+ name);
		return "Success";
	}
	
}

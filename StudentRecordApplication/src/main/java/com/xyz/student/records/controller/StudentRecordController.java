package com.xyz.student.records.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.xyz.student.records.model.Student;
import com.xyz.student.records.service.StudentRecordService;

@RestController
@RequestMapping("/studentrecords")
public class StudentRecordController {

	@Autowired
	private StudentRecordService studentRecordService;

	/**
	 * fetch student information
	 * 
	 * @return
	 */
	@RequestMapping(value = "/fetch", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<List<Student>> fetchDetails() {
		List<Student> studentList = new ArrayList<>();
		studentList = studentRecordService.fetchDetails();
		return ResponseEntity.ok().body(studentList);
	}

	/**
	 * save student information
	 * 
	 * @return
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<String> saveDetails(@RequestBody Student student) {
		studentRecordService.saveDetails(student);
		return ResponseEntity.ok().body("Successfully stored");
	}
}

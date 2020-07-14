package com.xyz.student.records.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xyz.student.records.dao.StudentRecordRepository;
import com.xyz.student.records.model.Student;

@Service("/studentRecordServices")
public class StudentRecordService {

	@Autowired
	private StudentRecordRepository studentRecordRepository;
	
	/**
	 * fetch student information
	 * @return
	 */
	public List<Student> fetchDetails() {
		List<Student> list = (List<Student>) studentRecordRepository.findAll();
		return list;
	}
	
	/**
	 * fetch student information
	 * @return
	 */
	public void saveDetails(Student student) {
		studentRecordRepository.save(student);
	}
}

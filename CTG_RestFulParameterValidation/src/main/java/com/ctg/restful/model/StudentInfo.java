package com.ctg.restful.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.NumberFormat;

import com.ctg.restful.Group;

public class StudentInfo {

	@Min(3)
	private int id;
	
	@NotEmpty(message = "{student.firstName.required}")
	@Size(min=2, max=30, message= "{student.firstName.size.required}") 
	private String firstName;
	
	@NotEmpty(message = "{student.lastName.required}")
	@Size(min=2, max=30) 
	private String lastName;
	
	@NotEmpty 
	@Email(message = "{student.emailId.required}")
	private String emailAddress;
	
	@Pattern(regexp = "\\d{10}", message = "{student.phoneNumber.required}")
	@NumberFormat
	private String phoneNumber;
	
	@Group
	private String courseGroup;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getCourseGroup() {
		return courseGroup;
	}

	public void setCourseGroup(String courseGroup) {
		this.courseGroup = courseGroup;
	}

}

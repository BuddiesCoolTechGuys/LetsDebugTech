package com.ctg.restful.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.NumberFormat;

public class StudentInfo {

	@NotNull(message = "Id should not be empty")
	@Min(3)
	private int id;
	
	@NotEmpty(message = "First Name should not be empty")
	@Size(min=2, max=30) 
	private String firstName;
	
	@NotEmpty(message = "Last Name should not be empty")
	@Size(min=2, max=30) 
	private String lastName;
	
	@NotEmpty 
	@Email(message = "EmailId must be valid format")
	private String emailAddress;
	
	@Pattern(regexp = "\\d{10}", message = "Phone Number format is wrong")
	@NumberFormat
	private String phoneNumber;

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

}

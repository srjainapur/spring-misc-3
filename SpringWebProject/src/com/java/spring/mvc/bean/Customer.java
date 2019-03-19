package com.java.spring.mvc.bean;

import java.util.Date;


import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
//import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import com.java.spring.mvc.validator.Phone;

public class Customer {
	
	@Size(min=2, max=50)
	private String name;
	
	@NotEmpty @Email
	private String email;
	
	@NotNull @Min(18) @Max(100)
	private int age;
	
	@NotNull
	private String gender;
	
	@DateTimeFormat(pattern="MM/dd/yyyy")
	@NotNull @Past
	private Date dateOfBirth;
	
	@Phone
	private String phone;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}

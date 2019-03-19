package com.zensar.springboot.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "Employee.fetchByLastName", query = "SELECT e FROM Employee e WHERE lastName = ?1")
@NamedNativeQuery(name = "Employee.fetchByFirstNameAndEmpId", query = "SELECT * FROM EMPLOYEE e WHERE e.FIRST_NAME =:firstName AND e.EMPLOYEE_ID =:empId", resultClass=Employee.class)
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int employeeId;

	private String firstName;
	private String lastName;
	private String email;
	private Date dateOfBirth;

	public Employee(int employeeId, String firstName, String lastName, String email, Date dateOfBirth) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.dateOfBirth = dateOfBirth;
	}

	public Employee() {
		super();
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

}

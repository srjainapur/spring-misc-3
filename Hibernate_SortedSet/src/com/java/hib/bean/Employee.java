package com.java.hib.bean;

import java.util.SortedSet;

public class Employee {
	private int emp_id;
	private String firstName;
	private String lastName;
	private int salary;
	private SortedSet<Certificate> certificates;
	
	public Employee() {
		
	}

	public Employee(int emp_id, String firstName, String lastName, int salary) {
		super();
		this.emp_id = emp_id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
	}

	public int getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
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

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public SortedSet<Certificate> getCertificates() {
		return certificates;
	}

	public void setCertificates(SortedSet<Certificate> certificates) {
		this.certificates = certificates;
	}
}

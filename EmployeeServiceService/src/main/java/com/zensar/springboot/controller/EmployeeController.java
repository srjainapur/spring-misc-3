package com.zensar.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.springboot.model.Employee;
import com.zensar.springboot.service.EmployeeService;



@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeService empService;
	
	@GetMapping("/employees/{id}")
	public Employee getEmployeeById(@PathVariable("id") int empId) {
		return empService.getEmployeeById(empId).get();
	}
}

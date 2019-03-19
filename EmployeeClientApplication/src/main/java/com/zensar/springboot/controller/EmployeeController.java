package com.zensar.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.zensar.springboot.Employee.Employee;

@RestController
public class EmployeeController {
	 @Autowired
	 protected RestTemplate restTemplate;
	 
	 @GetMapping("/employees")
		public Employee getAllEmployees() {
			return restTemplate.getForObject("http://SERVICE//employees/{id}", Employee.class);
		}
}

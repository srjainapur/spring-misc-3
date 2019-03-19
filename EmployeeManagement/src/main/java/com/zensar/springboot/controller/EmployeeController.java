package com.zensar.springboot.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.springboot.boot.Employee;
import com.zensar.springboot.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeService empService;
	
	@GetMapping("/employees")
	public Iterable<Employee> getAllEmployees() {
		return empService.getAllEmployees();
	}
	
	@PostMapping("/employees")
	public Employee insertEmployee(Employee employee) {
		return empService.insertEmployee(employee);
	}
	
	@RequestMapping(value="/employees", method=RequestMethod.DELETE)
	public Iterable<Employee> deleteEmployee(@RequestBody Employee employee) {
		empService.deleteEmployee(employee.getEmpId());
		return empService.getAllEmployees();
	}
	
	@PutMapping("/employee")
	public Employee updateEmployee(@RequestBody Employee employee) {
		return empService.updateEmployee(employee);
	}
}

package com.zensar.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.springboot.model.Employee;
import com.zensar.springboot.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService empService;
	
	@GetMapping("/employee")
	public List<Employee> getAllEmployee() {
		return empService.getAllEmployee();
	}
	
	@GetMapping("/employee/{empId}")
	public Employee getEmployeeById(@PathVariable("empId") int empId) {
		return empService.getEmployeeById(empId);
	}
	
	
	@PostMapping("/employee")
	public List<Employee> insertEmployee(@RequestBody Employee employee) {
		empService.insertEmployee(employee);
		return empService.getAllEmployee();
	}
	
	@PatchMapping("/employee/update/{empId}")
    public Employee updateEmployeeById(@PathVariable("empId") int empId, @RequestBody Employee employee) {
		return empService.updateEmployeeById(empId, employee);
	}
	
	 @DeleteMapping("/employee/delete/{empId}")
	 public void deleteEmployeeById(@PathVariable("empId") int empId){
		 empService.deleteEmployeeById(empId);
	 }
}

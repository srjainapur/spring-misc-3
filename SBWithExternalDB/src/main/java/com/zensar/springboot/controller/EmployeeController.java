package com.zensar.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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
	public Iterable<Employee> getAllEmployees() {
		return empService.getAllEmployees();
	}
	
	@PostMapping("/employee")
	public Employee insertEmployee(@RequestBody Employee employee) {
		return empService.insertEmployee(employee);
	}
	
	@GetMapping("/employee/{name}")
	public Employee getEmployeeByName(@PathVariable String name) {
		return empService.getEmployeeByName(name);
	}
	
	@PutMapping("/employee/update/{id}")
	public Employee updateEmployee(@PathVariable("id") int empId, @RequestBody Employee employee) {
		return empService.updateEmployee(empId, employee);
	}
	
	@DeleteMapping("/employee/delete/{id}")
	public Iterable<Employee> deleteEmployee(@PathVariable("id") int empId) {
		empService.deleteEmployeeById(empId);
		
		return empService.getAllEmployees();
	}
	
	@GetMapping("/employee/lastname/{name}")
	public Employee fetchByLastName(@PathVariable String name) {
		return empService.fetchByLastName(name);
	}
	
	@GetMapping("employee/firstName/{name}")
	public Employee findByFirstName(@PathVariable String name) {
		return empService.findByFirstName(name);
	}
	
	
	@GetMapping("/employee/name/{name}/empId/{empId}")
	public Employee fetchByFirstNameAndEmpId(@PathVariable("name") String firstName, @PathVariable("empId") Integer empId) {
		return empService.fetchByFirstNameAndEmpId(firstName, empId);
	}
	
	@GetMapping("/employee/email/{email}")
	public Employee fetchEmployeeByEmail(@PathVariable("email") String email) {
		return empService.fetchEmployeeByEmail(email);
	}
	
	@PutMapping("/employee/update/email/{email}/empId/{empId}")
	public int updateEmployeeEmail(@PathVariable("email") String email, @PathVariable("empId") int empId) {
		return empService.updateEmployeeEmail(email, empId);
	}
}

package com.zensar.springboot.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.springboot.model.Employee;
import com.zensar.springboot.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeDAO;
	
	public Iterable<Employee> getAllEmployees() {
		return employeeDAO.findAll();
	}

	public Employee insertEmployee(Employee employee) {
		return employeeDAO.save(employee);
	}

	public Employee getEmployeeByName(String name) {
		return employeeDAO.findByFirstName(name);
	}

	public Employee updateEmployee(int empId, Employee employee) {
		
		Employee oldEmployee = employeeDAO.findById(empId).get();
		oldEmployee.setFirstName(employee.getFirstName());
		oldEmployee.setLastName(employee.getLastName());
		oldEmployee.setEmail(employee.getEmail());
		oldEmployee.setDateOfBirth(employee.getDateOfBirth());
		
		return employeeDAO.save(oldEmployee);
		//return null;
	}

	public void deleteEmployeeById(int empId) {
		employeeDAO.deleteById(empId);
	}

	public Employee fetchByLastName(String name) {
		return employeeDAO.fetchByLastName(name);
	}

	public Employee findByFirstName(String name) {
		// TODO Auto-generated method stub
		return employeeDAO.findByFirstName(name);
	}
	
	public Employee fetchByFirstNameAndEmpId(String firstName, Integer empId) {
		return employeeDAO.fetchByFirstNameAndEmpId(firstName, empId);
	}
	
	public Employee fetchEmployeeByEmail(String email) {
		return employeeDAO.fetchEmployeeByEmail(email);
	}

	public int updateEmployeeEmail(String email, int empId) {
		return employeeDAO.updateEmployeeEmail(email, empId);
	}

}

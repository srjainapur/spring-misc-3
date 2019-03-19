package com.zensar.springboot.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.springboot.model.Employee;
import com.zensar.springboot.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeDAO;
	
	public List<Employee> getAllEmployee() {
		Iterable<Employee> itEmp = employeeDAO.findAll();
		
		System.out.println("Iterable Emp : " + itEmp);
		
		List<Employee> empList = new ArrayList<>();
		for(Employee e : itEmp) {
			empList.add(e);
		}
		System.out.println("Employee Lis : " + empList);
		return empList;
	}

	public Employee getEmployeeById(int empId) {		
		return employeeDAO.findById(empId).get();
	}

	public void insertEmployee(Employee employee) {
		employeeDAO.save(employee);
	}

	public Employee updateEmployeeById(int empId, Employee employee) {
		Employee oldEmployee = employeeDAO.findById(empId).get();
		oldEmployee.setFirstName(employee.getFirstName());
		oldEmployee.setLastName(employee.getLastName());
		oldEmployee.setEmail(employee.getEmail());
		oldEmployee.setDateOfBirth(employee.getDateOfBirth());
		
		return employeeDAO.save(oldEmployee);
	}

	public void deleteEmployeeById(int empId) {
		employeeDAO.deleteById(empId);;
	}
}

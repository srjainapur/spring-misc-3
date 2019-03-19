package com.zensar.springboot.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.springboot.model.Employee;
import com.zensar.springboot.repository.EmployeeRepository;


@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepo;
	
	public Optional<Employee> getEmployeeById(int empId) {
		return employeeRepo.findById(empId);
	}
	
	/*public Employee insertEmployee(Employee employee) {
		return employeeRepo.save(employee);
	}
	
	public void deleteEmployee(int empId) {
		Optional<Employee> employee = employeeRepo.findById(empId);
		employeeRepo.delete(employee.get());
	}
	
	public Employee updateEmployee(Employee pEmployee) {
		Optional<Employee> employee = employeeRepo.findById(pEmployee.getEmpId());
		Employee emp = employee.get();
		emp.setEmpName(pEmployee.getEmpName());
		emp.setEmpEmail(pEmployee.getEmpEmail());
		emp.setSalary(pEmployee.getSalary());
		return employeeRepo.save(emp);
	}*/
}
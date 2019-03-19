package com.zensar.springboot.repository;

import org.springframework.data.repository.CrudRepository;

import com.zensar.springboot.model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer>{

}

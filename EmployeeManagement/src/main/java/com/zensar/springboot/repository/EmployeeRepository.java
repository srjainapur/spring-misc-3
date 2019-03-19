package com.zensar.springboot.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.zensar.springboot.boot.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

}

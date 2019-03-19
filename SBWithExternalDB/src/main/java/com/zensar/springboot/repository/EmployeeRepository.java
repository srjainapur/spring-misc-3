package com.zensar.springboot.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.zensar.springboot.model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer>{
	public Employee findByFirstName(String name);
	public Employee fetchByLastName(String lastName);
	public Employee fetchByFirstNameAndEmpId(@Param("firstName") String firstName, @Param("empId") int empId);
	
	@Query(value="SELECT * FROM EMPLOYEE WHERE EMAIL =:email", nativeQuery=true)
	public Employee fetchEmployeeByEmail(@Param("email") String email);
	
	@Transactional
	@Modifying(clearAutomatically=true)
	@Query(value = "UPDATE EMPLOYEE SET EMAIL =:email WHERE EMPLOYEE_ID =:empId", nativeQuery = true )
	public int updateEmployeeEmail(@Param("email") String email, @Param("empId") int empId);
}

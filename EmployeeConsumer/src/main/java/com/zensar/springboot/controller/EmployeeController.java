package com.zensar.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.zensar.springboot.model.Employee;

@RestController
public class EmployeeController {
	
	@Autowired
	DiscoveryClient client;
	
    @Autowired
    private RestTemplate restTemplate;
    
    @PostMapping("/employee")
    public Employee[] saveEmployee(@RequestBody Employee employee) {
    	String url = getURL() + "/employee";
    	ResponseEntity<Employee[]> empList = restTemplate.postForEntity(url, employee, Employee[].class);
    	return empList.getBody();
    }
    
    
    @GetMapping("/employee/{empId}")
    public Employee getEmployeeById(@PathVariable("empId") int empId) {
    	
    	Map<String, Object> uriVariables = new HashMap<>();
    	uriVariables.put("empId", empId);
    	
    	String url = getURL() + "/employee/{empId}";
    	
    	ResponseEntity<Employee> responseEntity = restTemplate.getForEntity(url, Employee.class, uriVariables);
    	Employee employee = responseEntity.getBody();
    	
    	return employee;
    }
    
    
    @GetMapping("/fetch/all/employee")
    public Employee[] getEmployee() {
    	String url = getURL() + "/employee";
    	
    	ResponseEntity<Employee[]> responseEntity = restTemplate.getForEntity(url, Employee[].class);
    	System.out.println("responseEntity " + responseEntity);
    	
    	return responseEntity.getBody();
    }
    
    @PostMapping("/employee/update/{empId}")
    public void updateEmployeeById(@PathVariable("empId") int empId, @RequestBody Employee employee) {
    	String url = getURL() + "/employee/update/{empId}?_method=patch";
    	Map<String, Object> uriVariables = new HashMap<>();
    	uriVariables.put("empId", empId);
    	
    	restTemplate.postForObject(url, employee, Employee.class, uriVariables);
    	//return patchForObject;
    }
    
    @DeleteMapping("/employee/delete/{empId}")
    public void deleteEmployeeById(@PathVariable("empId") int empId){
    	
    	String url = getURL() + "/employee/delete/{empId}";
    	Map<String, Object> uriVariables = new HashMap<>();
    	uriVariables.put("empId", empId);
    	
    	restTemplate.delete(url, uriVariables);
    }
    
    
    public String getURL() {
    	List<ServiceInstance> application = client.getInstances("Employee-Server");
    	ServiceInstance instanceInfo = application.get(0);
    	String url = "http://" + instanceInfo.getHost() + ":" + instanceInfo.getPort();
    	
    	return url;
    }
}

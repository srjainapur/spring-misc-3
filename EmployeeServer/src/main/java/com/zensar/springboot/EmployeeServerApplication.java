package com.zensar.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class EmployeeServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeServerApplication.class, args);
	}
}

package com.zensar.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
public class EmployeeClientApplication {
	
	public static final String SERVICE_URL = "http://SERVICE";
	
	public static void main(String[] args) {
		SpringApplication.run(EmployeeClientApplication.class, args);
	}
	
	@Bean
	public RestTemplate restTemplate() {
	  return new RestTemplate();
	}
	
	
}

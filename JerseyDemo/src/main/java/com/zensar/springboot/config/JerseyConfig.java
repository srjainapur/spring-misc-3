package com.zensar.springboot.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.zensar.springboot.resource.UserResource;

@Component
public class JerseyConfig extends ResourceConfig {
	
	public JerseyConfig() {
		register(UserResource.class);
	}
}

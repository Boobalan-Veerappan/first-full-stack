package com.heraizen.gift.configuration;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import com.heraizen.gift.controller.Controller;

@Configuration
public class JerseyConfig extends ResourceConfig {

	JerseyConfig()
	{
		register(Controller.class);
	}
	
}

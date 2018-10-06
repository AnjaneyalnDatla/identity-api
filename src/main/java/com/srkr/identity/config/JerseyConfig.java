package com.srkr.identity.config;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import com.srkr.identity.rest.HealthController;
import com.srkr.identity.rest.LoginController;
import com.srkr.identity.rest.PersonController;

@Configuration
@ApplicationPath("/identity")
public class JerseyConfig extends ResourceConfig {

	public JerseyConfig() {
		register(PersonController.class);
		register(LoginController.class);
		register(HealthController.class);
	}

}

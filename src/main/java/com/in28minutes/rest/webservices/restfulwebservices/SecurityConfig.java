package com.in28minutes.rest.webservices.restfulwebservices;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	/*
	 * Esta anotacion es necesaria si el cliente no va usar necesarimamente un
	 * WebBroser
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().headers().frameOptions().disable().and().authorizeRequests().anyRequest().authenticated().and().httpBasic();
	}

}

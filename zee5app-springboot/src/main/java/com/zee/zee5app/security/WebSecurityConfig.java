package com.zee.zee5app.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
// it will have only security related configurations
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)  // pre/post authorize can be accessed by setting true
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	
}

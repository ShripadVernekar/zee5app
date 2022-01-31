package com.zee.zee5app.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

//it is used to mark on config class/classes
@Configuration
//it scans for the files from specified location
@ComponentScan("com.zee.zee5app")
//responsible for reading property file
@PropertySource("classpath:application.properties")

// here we will hold all commonly required objects for app
//config : db related, reading prop file. commonly required beans (passwordEncoder)
public class Config {

//will bring the already created objects based on the name / type
	@Autowired
// this impl obj is created by spring
	Environment environment;

	//if we do not specify bean name then by default method name is taken as bean name
	@Bean // for providing singleton object
	public DataSource dataSource() {
		BasicDataSource basicDataSource = new BasicDataSource();
		basicDataSource.setUsername(environment.getProperty("jdbc.username"));
		basicDataSource.setPassword(environment.getProperty("jdbc.password"));
		basicDataSource.setUrl(environment.getProperty("jdbc.url"));
		basicDataSource.setDefaultAutoCommit(false);
		return basicDataSource;
	}

} // end of class

package com.zee.zee5app.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

//class to get db connection and close it
public class DBUtils {

	
	Connection connection = null;
	private DBUtils() throws IOException {
		properties = loadProperties();
	}

	Properties properties;
	public static DBUtils dbutils;

	public static DBUtils getInstance() throws IOException {
		if (dbutils == null)
			dbutils = new DBUtils();
		return dbutils;
	}

//	get connection with the db
	public Connection getConnection() {
//		Properties properties;

		try {
			/*
			 * // properties = loadProperties(); //since if this gets called multiple times
			 * then mem is wasted by initialising it multiple times //so added it to the
			 * constructor so it is allocated once and used many times
			 */ 
			if (connection == null || connection.isClosed()) {
				connection = DriverManager.getConnection(properties.getProperty("jdbc.url"),
						properties.getProperty("jdbc.username"), properties.getProperty("jdbc.password"));
				connection.setAutoCommit(false);
			}
//			System.out.println(properties);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return connection;
	}

	public void closeConnection(Connection connection) {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private Properties loadProperties() throws IOException {
		InputStream inputStream = DBUtils.class.getClassLoader().getResourceAsStream("application.properties");

		Properties properties = new Properties();
//		below one read the properties internally
		properties.load(inputStream);
		return properties;
	}

}

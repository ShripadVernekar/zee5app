package com.learning.utils;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;


public class CustomNamingStrategy extends PhysicalNamingStrategyStandardImpl {

	private final static String POSTFIX = "_table";
	// by default all tables shd be ended with _table and we don't want to apply _table for all entity specs 
	// will set as thumb rule
	
	@Override
	public Identifier toPhysicalTableName(Identifier identifier, JdbcEnvironment context) {
		if(identifier == null)
			return null;
		final String newName = identifier.getText() + POSTFIX;
		// table name 1. if @table is available then it will use that name
		// 2. else it will take entity name if entity name is not there then by default it takes class name as entity name
		return identifier.toIdentifier(newName);
	}
	
	@Override
	public Identifier toPhysicalColumnName(Identifier identifier, JdbcEnvironment context) {
		if(identifier == null)
			return null;
//		final String newName = identifier.getText() + POSTFIX;
		// table name 1. if @table is available then it will use that name
		// 2. else it will take entity name if entity name is not there then by default it takes class name as entity name
		return identifier.toIdentifier(identifier.getText().toLowerCase());
	}
	
}

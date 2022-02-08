package com.learning.exception;

import lombok.ToString;

@ToString(callSuper = true)

public class TypeNotFoundException extends Exception {
	
	public TypeNotFoundException(String message) {
		// TODO Auto-generated constructor stub
		super(message);
	}
	
}

package com.zee.zee5app.exception;

import lombok.ToString;

@ToString(callSuper = true)
public class InvalidEmailException extends Exception {
	
	public InvalidEmailException(String msg) {
		// TODO Auto-generated constructor stub
		super(msg);
	}
}

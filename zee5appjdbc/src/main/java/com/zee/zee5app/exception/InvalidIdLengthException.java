package com.zee.zee5app.exception;

import lombok.ToString;

@ToString(callSuper = true)

public class InvalidIdLengthException extends Exception {
		//user defined exception
	
	//we have to do below for any custom 
	public InvalidIdLengthException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	// below one is same as @ToString(callSuper = true)
/*
*	@Override
*	public String toString() {
*		return "IdNotFoundException [toString()=" + super.toString() + "]";
*	}
*/
	

	
}

package com.zee.zee5app.exception;

import lombok.ToString;

@ToString

public class InvalidAmountException extends Exception {

	public InvalidAmountException(String msg) {
		// TODO Auto-generated constructor stub
		super(msg);
	}
}

package com.tyss.smsproject.exceptionclasses;

public class InvalidEmailAndPasswordException extends RuntimeException{
	@Override
	public String getMessage() {
		return "Invalid Credentials, ie. Invalid Email and Password";
	}
}

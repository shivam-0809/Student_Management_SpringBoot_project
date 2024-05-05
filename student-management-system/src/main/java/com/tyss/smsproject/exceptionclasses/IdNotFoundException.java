package com.tyss.smsproject.exceptionclasses;

public class IdNotFoundException extends RuntimeException {
	
	@Override
	public String getMessage() {
		return "Invalid Student ID, Student With This ID Is Not Present In Database";
	}
}

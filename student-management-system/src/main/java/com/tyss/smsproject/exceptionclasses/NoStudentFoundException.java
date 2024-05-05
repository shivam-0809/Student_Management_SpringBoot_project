package com.tyss.smsproject.exceptionclasses;

public class NoStudentFoundException extends RuntimeException{
	@Override
	public String getMessage() {
		return "No Student Are Present In Database, Database Is Empty.. ";
	}
}

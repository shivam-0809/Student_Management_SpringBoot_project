package com.tyss.smsproject.exceptionclasses;

public class InvalidPhoneAndPasswordException  extends RuntimeException{
	@Override
	public String getMessage() {
		return "Invaid Creadentials, ie. Inavlid Phone And Password";
	}
}

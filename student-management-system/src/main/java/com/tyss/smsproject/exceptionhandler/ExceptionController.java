package com.tyss.smsproject.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.tyss.smsproject.exceptionclasses.IdNotFoundException;
import com.tyss.smsproject.exceptionclasses.InvalidEmailAndPasswordException;
import com.tyss.smsproject.exceptionclasses.InvalidPhoneAndPasswordException;
import com.tyss.smsproject.exceptionclasses.NoStudentFoundException;
import com.tyss.smsproject.responsestructure.ResponseStructure;

@RestControllerAdvice
public class ExceptionController {

	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> handleIdNotFoundException(IdNotFoundException idNotFoundException) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setStatusCode(HttpStatus.NO_CONTENT.value());
		structure.setMessage("Invalid Student Id");
		structure.setBody(idNotFoundException.getMessage());
		return new ResponseEntity<>(structure, HttpStatus.NO_CONTENT);
	}
	
	@ExceptionHandler(InvalidEmailAndPasswordException.class)
	public ResponseEntity<ResponseStructure<String>> handleInvalidEmailAndPasswordException(InvalidEmailAndPasswordException invalidEmailAndPasswordException) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setStatusCode(HttpStatus.NO_CONTENT.value());
		structure.setMessage("Invalid Student Email or Password...");
		structure.setBody(invalidEmailAndPasswordException.getMessage());
		return new ResponseEntity<>(structure, HttpStatus.NO_CONTENT);		
	}
	
	@ExceptionHandler(InvalidPhoneAndPasswordException.class)
	public ResponseEntity<ResponseStructure<String>> handleInvalidPhoneAndPasswordException(InvalidPhoneAndPasswordException invalidPhoneAndPasswordException) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setStatusCode(HttpStatus.NO_CONTENT.value());
		structure.setMessage("Invalid Student Phone or Password...");
		structure.setBody(invalidPhoneAndPasswordException.getMessage());
		return new ResponseEntity<>(structure, HttpStatus.NO_CONTENT);	
	}
	
	@ExceptionHandler(NoStudentFoundException.class)
	public ResponseEntity<ResponseStructure<String>> handleNoStudentFoundException(NoStudentFoundException noStudentFoundException) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setStatusCode(HttpStatus.NO_CONTENT.value());
		structure.setMessage("Invalid Student Phone or Password...");
		structure.setBody(noStudentFoundException.getMessage());
		return new ResponseEntity<>(structure, HttpStatus.NO_CONTENT);		
	}
}

package com.tyss.smsproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tyss.smsproject.dao.StudentDao;
import com.tyss.smsproject.dto.Student;
import com.tyss.smsproject.exceptionclasses.IdNotFoundException;
import com.tyss.smsproject.exceptionclasses.InvalidPhoneAndPasswordException;
import com.tyss.smsproject.exceptionclasses.NoStudentFoundException;
import com.tyss.smsproject.responsestructure.ResponseStructure;

@Service
public class StudentService {

	@Autowired
	StudentDao dao;

	public ResponseEntity<ResponseStructure<Student>> saveStudent(Student student) {
		Student dbstudent = dao.saveStudent(student);
		ResponseStructure<Student> structure = new ResponseStructure<>();
		if (dbstudent != null) {
			structure.setStatusCode(HttpStatus.CREATED.value());
			structure.setMessage("Student Saved Successfully...");
			structure.setBody(dbstudent);
			return new ResponseEntity<>(structure, HttpStatus.OK);
		}
		structure.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
		structure.setMessage("Can't Save Student");
		structure.setBody(null);
		return new ResponseEntity<>(structure, HttpStatus.NOT_ACCEPTABLE);
	}

	public ResponseEntity<ResponseStructure<Student>> updateStudent(Student student) {
		Student dbstudent = dao.updateStudent(student);
		ResponseStructure<Student> structure = new ResponseStructure<>();
		if (dbstudent != null) {
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setMessage("Student Updated Successfully...");
			structure.setBody(dbstudent);
			return new ResponseEntity<>(structure, HttpStatus.OK);
		}
		structure.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
		structure.setMessage("Can't Update Student");
		structure.setBody(null);
		return new ResponseEntity<>(structure, HttpStatus.NOT_ACCEPTABLE);
	}
	
	public ResponseEntity<ResponseStructure<Student>> findStudentByID(int id) {
		Optional<Student> dbstudent = dao.findStudentById(id);
		ResponseStructure<Student> structure = new ResponseStructure<Student>();
			if (!dbstudent.isPresent()) {
				throw new IdNotFoundException();
			}
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setMessage("Student Found Successfully..");
			structure.setBody(dbstudent.get());
			return new ResponseEntity<>(structure, HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<String>> deleteStudent(int id) {
		Optional<Student> dbstudent = dao.findStudentById(id);
		ResponseStructure<String> structure = new ResponseStructure<>();
		if (!dbstudent.isPresent()) 
			throw new IdNotFoundException();
		dao.deleteStudent(id);
		structure.setStatusCode(HttpStatus.OK.value());
		structure.setMessage("Student Deleted Successfully...");
		structure.setBody("Given Student Id Record Deleted Successfully...");
		return new ResponseEntity<>(structure, HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<Student>> findStudentByPhoneAndPassword(long phone, String password) {
		ResponseStructure<Student> structure = new ResponseStructure<>();
		Student dbstudent = dao.findStudentByPhoneAndPassword(phone, password);
		if (dbstudent == null)
			throw new InvalidPhoneAndPasswordException();
		structure.setStatusCode(HttpStatus.OK.value());
		structure.setMessage("Student Found Successfully...");
		structure.setBody(dbstudent);
		return new ResponseEntity<>(structure, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<Student>> findStudentByEmailAndPassword(String email, String password) {
		ResponseStructure<Student> structure = new ResponseStructure<>();
		Student dbstudent = dao.findStudentByEmailAndPassword(email, password);
		if (dbstudent == null)
			throw new InvalidPhoneAndPasswordException();
		structure.setStatusCode(HttpStatus.OK.value());
		structure.setMessage("Student Found Successfully...");
		structure.setBody(dbstudent);
		return new ResponseEntity<>(structure, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<List<Student>>> findAllStudents() {
		List<Student> students = dao.findAllStudents();
		if (students.isEmpty())
			throw new NoStudentFoundException();
		ResponseStructure<List<Student>> structure = new ResponseStructure<>();
		structure.setStatusCode(HttpStatus.OK.value());
		structure.setMessage("All Student's Are Fetched From Database Successfully...");
		structure.setBody(students);
		return new ResponseEntity<>(structure, HttpStatus.OK);
	}











}

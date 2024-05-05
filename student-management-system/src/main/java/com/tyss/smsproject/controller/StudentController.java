package com.tyss.smsproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tyss.smsproject.dto.Student;
import com.tyss.smsproject.responsestructure.ResponseStructure;
import com.tyss.smsproject.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	StudentService service;
	
	@GetMapping("/hii")
	public String name() {
		return "Hello from home";
	}
	
	@PostMapping(value = "/student")
	public ResponseEntity<ResponseStructure<Student>> saveStudent(@RequestBody Student student) {
		return service.saveStudent(student);
	}
	
	@PutMapping(value = "/student")
	public ResponseEntity<ResponseStructure<Student>> updateStudent(@RequestBody Student student) {
		return service.updateStudent(student);
	}
	
	@DeleteMapping("/student/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteStudent(@PathVariable int id) {
		return service.deleteStudent(id);
	}
	
	@GetMapping("/student/{id}")
	public ResponseEntity<ResponseStructure<Student>> findStudent(@PathVariable int id) {
		return service.findStudentByID(id);
	}
	
	@GetMapping(value = "/student/all")
	public ResponseEntity<ResponseStructure<List<Student>>> findAllStudent() {
		return service.findAllStudents();
	}
	
	@GetMapping("/student/{phone}/{password}")
	public ResponseEntity<ResponseStructure<Student>> findStudentByPhoneAndPassword(@PathVariable long phone, @PathVariable String password) {
		return service.findStudentByPhoneAndPassword(phone, password);
	}
	
	@GetMapping("/student")
	public ResponseEntity<ResponseStructure<Student>> findStudentByEmailAndPassword(@RequestParam String email, String password) {
		return service.findStudentByEmailAndPassword(email, password);
	}
	
}

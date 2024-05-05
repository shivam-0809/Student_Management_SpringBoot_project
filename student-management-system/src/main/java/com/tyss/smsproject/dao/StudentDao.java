package com.tyss.smsproject.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tyss.smsproject.dto.Student;
import com.tyss.smsproject.repository.StudentRepository;

@Repository
public class StudentDao {

	@Autowired
	private StudentRepository repository;

	public Student saveStudent(Student student) {
		return repository.save(student);
	}

	public Student updateStudent(Student student) {
		return repository.save(student);
	}

	public Optional<Student> findStudentById(int id) {
		return repository.findById(id);
	}

	public void deleteStudent(int id) {
		repository.deleteById(id);
	}

	public Student findStudentByPhoneAndPassword(long phone, String password) {
		return repository.findByPhoneAndPassword(phone, password);
	}

	public Student findStudentByEmailAndPassword(String email, String password) {
		return repository.findByEmailAndPassword(email, password);
	}

	public List<Student> findAllStudents() {
		return repository.findAll();
	}
}

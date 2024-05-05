package com.tyss.smsproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tyss.smsproject.dto.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{
	Student findByPhoneAndPassword(long phone, String password);
	Student findByEmailAndPassword(String email, String password);
}

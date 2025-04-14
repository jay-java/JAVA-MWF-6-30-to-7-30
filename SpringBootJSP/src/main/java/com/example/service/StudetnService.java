package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Student;
import com.example.repo.StudentRepository;

@Service
public class StudetnService {

	@Autowired
	private StudentRepository repo;

	public void insetStudent(Student s) {
		this.repo.save(s);
	}
	
	public List<Student> getAllStudents(){
	 	return this.repo.findAll();
	}
}

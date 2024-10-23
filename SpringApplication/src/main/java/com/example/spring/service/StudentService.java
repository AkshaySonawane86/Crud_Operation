package com.example.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring.model.Student;
import com.example.spring.repository.StudentRepo;
import com.example.spring.repository.StudentRepository;
import java.util.*;

@Service("studentService")
public class StudentService {

	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	StudentRepo repo;
	
	public List<Student> getAllStudent()
	{
		List<Student> students=repo.findAll();
		return students;
	}
	
	public Student getStudent(int id)
	{
		Student student=repo.findById(id).get();
		return student;
	}
	
	public void createStudent(Student student)
	{
		repo.save(student);
	}
	
	public Student updateStudent(int id)
	{
		Student student=repo.findById(id).get();
		student.setName("aaa");
		student.setPercentage(90);
		student.setBranch("co");
		repo.save(student);
		return student;
	}
	
	public void removeStudent(int id)
	{
		Student student=repo.findById(id).get();
		repo.delete(student);
	}
}

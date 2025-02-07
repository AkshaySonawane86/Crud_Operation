package com.example.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring.model.Student;
import com.example.spring.service.StudentService;

import java.util.*;

@RestController
public class StudentController {
	
	@Autowired
	StudentService studentService;

	//localhost:8081/students
	@GetMapping("/students")
	public List<Student> getAllStudent()
	{
		return studentService.getAllStudent();
	}
	
//	localhost:8082/students/1
	@GetMapping("/students/{id}")
	public Student getStudent(@PathVariable int id)
	{
		return studentService.getStudent(id);
	}
	
//	localhost:8082/student/add
	@PostMapping("/student/add")
	public void createStudent(@RequestBody Student student)
	{
		studentService.createStudent(student);
	}
	
//	localhost:8082/student/update/2
	@PutMapping("/student/update/{id}")
	public Student updateStudent(@PathVariable int id)
	{
		return studentService.updateStudent(id);
	}
	
//	localhost:8082/student/delete/1
	@DeleteMapping("/student/delete/{id}")
	public void removeStudent(@PathVariable int id)
	{
		studentService.removeStudent(id);
	}
}

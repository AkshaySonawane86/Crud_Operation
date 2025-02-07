package com.example.spring.controller;

import java.io.IOException;
import java.util.*;

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

@RestController
public class StudentController {

	@Autowired
	StudentService studentService;
	
//	localhost:8082/student/add
	@PostMapping("/student/add")
	public void createStudent(@RequestBody Student student) throws IOException
	{
		studentService.addStudent(student);
	}
	
//	localhost:8082/students/all
	@GetMapping("/student/all")
	public List<Student> getAllStudent() throws IOException
	{
		return studentService.getAllStudent();
	}
	
//	localhost:8082/student/update
	@PutMapping("/student/update/{id}")
	public String updateStudent(@PathVariable int id) throws IOException
	{
		return studentService.updateStudent(id);
	}
	
//	localhost:8082/students/delete/1
	@DeleteMapping("/student/delete/{id}")
	public String deleteStudent(@PathVariable int id) throws IOException
	{
		return studentService.deleteStudent(id);
	}
	
	
}

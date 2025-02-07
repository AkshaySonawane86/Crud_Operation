package com.example.spring.service;

import java.io.IOException;
import java.util.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import org.springframework.stereotype.Service;

import com.example.spring.model.Student;

@Service
public class StudentService {

	private final String filePath = "C:/data/student.txt";
	
	public String addStudent(Student student) throws IOException
	{
		String studentData = student.getId()+","+student.getName()+","+student.getPercentage()+","+student.getBranch()+"\n";
		Files.write(Paths.get(filePath), studentData.getBytes(), StandardOpenOption.APPEND);
		return "Add successfully";
	}
	
	public List<Student> getAllStudent() throws IOException
	{
		List<String> lines= Files.readAllLines(Paths.get(filePath));
		List<Student> student = new ArrayList<>();
		for(String line : lines)
		{
			String data[] = line.split(",");
			student.add(new Student(Integer.parseInt(data[0]),data[1],Double.parseDouble(data[2]),data[3]));
			
		}
		return student;
	}
	
	 public String updateStudent(int id) throws IOException
	 {
		 List<String> lines = Files.readAllLines(Paths.get(filePath));
		 List<String> updatedLines = new ArrayList<>();
		 boolean studentFound = false;
		 for(String line:lines)
		 {
			 String data[] = line.split(",");
			 if(Integer.parseInt(data[0]) == id)
			 {
				 updatedLines.add(id+","+"ee"+","+88+","+"entc");
				 studentFound = true;
			 }
			 else
			 {
				 updatedLines.add(line);
			 }
		 }
		 
		 if(studentFound)
		 {
			 Files.write(Paths.get(filePath), updatedLines);
			 return "Student updated";
		 }
		 else
		 {
			 return "Student not found";
		 }
	 }
	 
	 public String deleteStudent(int id) throws IOException
	 {
		 List<String> lines = Files.readAllLines(Paths.get(filePath));
		 List<String> updatedLines = new ArrayList<>();
		 boolean studentFound = false;
		 for(String line : lines)
		 {
			 String data[] = line.split(",");
			 if(Integer.parseInt(data[0])!=id)
			 {
				 updatedLines.add(line);
			 }
			 else
			 {
				 studentFound = true;
			 }
		 }
		 
		 Files.write(Paths.get(filePath), updatedLines);
		 if(studentFound)
		 {
			 return "Student deleted";
		 }
		 else
		 {
			 return "Student not found";
		 }
	 }
}

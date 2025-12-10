package com.example.StudentApp.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.StudentApp.pojos.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	
	List<Student> students = new ArrayList();
	
	public List<Student> loadStudents(){
		students.add(new Student(1, "ABC",8.9));
		students.add(new Student(2, "XYZ",7.9));
		students.add(new Student(3, "ASDF",8.1));
		students.add(new Student(4, "PQR",9.1));
		students.add(new Student(5, "ABCD",7.7));
		return students;
	}

	@GetMapping("/students")
	public List<Student> getAllStudents(){
		List<Student> studs = loadStudents();
		return studs; // JSON Array => Jackson
	}
	
	@GetMapping("/students/{id}")
	public Student getStudent(@PathVariable("id") int studId) {
		List<Student> studs = loadStudents();
		return studs.get(studId); // JSON object 
	}
	
	@PostMapping("/students")
	public Student createStudent(@RequestBody Student student) {
		System.out.println(student); // console 
		return student; // object => JSON object
	}
	
	
	
}

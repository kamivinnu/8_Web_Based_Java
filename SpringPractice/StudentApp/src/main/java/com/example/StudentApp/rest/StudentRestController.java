package com.example.StudentApp.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.StudentApp.pojos.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	
	List<Student> students = new ArrayList();
	
	public List<Student> loadStudents() {
		
		students.add(new Student(1, "ABC", 8.2));
		
		students.add(new Student(2, "DEF", 9.2));
		
		students.add(new Student(3, "GHI", 7.2));
		
		students.add(new Student(4, "JKL", 6.2));
		
		students.add(new Student(5, "MNO", 5.2));
		return students;
	}
	
	@GetMapping("/students")
	public List<Student> getAllStudents() {
		List<Student> studs = loadStudents();
		return studs;
	}
	
	@GetMapping("/students/{id}")
	public Student getStudentByID(@PathVariable("id") int studId) {
		List<Student> studs = loadStudents();
		return studs.get(studId); // JSON object
	}
	
	@PostMapping("/students")
	public Student createStudent(@RequestBody Student student) {
		System.out.println(student); // console
		return student; // object --> JSON object
	}
}

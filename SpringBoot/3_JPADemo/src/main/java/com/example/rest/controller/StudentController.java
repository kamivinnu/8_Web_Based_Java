package com.example.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.DeleteExchange;

import com.example.rest.dao.StudentDao;
import com.example.rest.entity.Student;

@RestController
public class StudentController {
    
	@Autowired
	private StudentDao studentDao; //
	
	@GetMapping("/students/{studentId}")
	public Student getStudentById(@PathVariable Integer studentId) {
		return studentDao.findById(studentId);
	}
	
	@GetMapping("/students")
	public List<Student> getStudents(){
		return studentDao.findAll(); // JSON Array
	}
	
	@PostMapping("/students")
	public String addStudent(@RequestBody Student stud) {
		studentDao.save(stud);
		return "student added successfully";
	}
	
	@PutMapping("/students")
	public String updateStudent(@RequestBody Student stud) {
		studentDao.update(stud);
		return "student updated successfully";
	}
	
	@DeleteMapping("students/{studentId}")
	public String deleteStudent(@PathVariable Integer studentId) {
        studentDao.delete(studentId);
		return "Student "+studentId+" deleted successfully!";
	}
}


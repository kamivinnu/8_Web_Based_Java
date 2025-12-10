package com.example.rest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rest.entity.Employee;
import com.example.rest.services.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/employees")
	public List<Employee> getEmployees(){
		return employeeService.findAllEmployees();
	}
	
	@GetMapping("/employees/{id}")
	public Optional<Employee> getEmployeeById(@PathVariable("id") Integer eid){
		return employeeService.findEmployeeByID(eid);
	}
	
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee emp) {
		return employeeService.saveAndUpdateEmployee(emp);
	}
	
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee emp) {
		return employeeService.saveAndUpdateEmployee(emp);
	}
	
	@DeleteMapping("/employees/{id}")
	public String deleteEmployee(@PathVariable("id") Integer eid) {
		employeeService.deleteEmployeeByID(eid);
		return "Employee with ID: "+eid+" deleted successfully!";
	}
}


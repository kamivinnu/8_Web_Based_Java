package com.example.restDemo.service;

import java.util.List;
import java.util.Optional;

import com.example.restDemo.entity.Employee;

public interface EmployeeService {
	List<Employee> findAll();
	public Optional<Employee> findById(int id);
	public Employee save(Employee employee); // insert and update
	public void deleteById(int id);	
}

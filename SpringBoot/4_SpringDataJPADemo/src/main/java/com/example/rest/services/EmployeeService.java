package com.example.rest.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.rest.entity.Employee;

@Service
public interface EmployeeService {
	public List<Employee> findAllEmployees();
	public Optional<Employee> findEmployeeByID(Integer id);
	public Employee saveAndUpdateEmployee(Employee emp);
	public void deleteEmployeeByID(Integer id);
    
}

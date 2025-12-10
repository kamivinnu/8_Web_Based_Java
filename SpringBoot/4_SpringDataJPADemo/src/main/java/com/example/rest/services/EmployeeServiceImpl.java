package com.example.rest.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rest.entity.Employee;
import com.example.rest.repos.EmployeeRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{
   
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public List<Employee> findAllEmployees() {
		List<Employee> emps = employeeRepository.findAll();
		return emps;
	}

	@Override
	public Optional<Employee> findEmployeeByID(Integer id) {
		return employeeRepository.findById(id);
	}

	@Override
	public Employee saveAndUpdateEmployee(Employee emp) {
		// id is present => update else create
		return employeeRepository.save(emp);
	}

	@Override
	public void deleteEmployeeByID(Integer id) {
		employeeRepository.deleteById(id);
	}
}

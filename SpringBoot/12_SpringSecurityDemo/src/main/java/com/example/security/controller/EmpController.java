package com.example.security.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.security.entity.Employee;
import com.example.security.service.EmpService;

@RestController
@RequestMapping("/api")
public class EmpController {

    @Autowired
    private EmpService empservice;

    @GetMapping("/emps")
    public List<Employee> getAllEmployees() {
        return empservice.findAllEmployees();
    }

    @GetMapping("/emps/{empid}")
    public Employee getEmpById(@PathVariable("empid") int empid) {
        return empservice.findEmpById(empid)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + empid));
    }

    @PostMapping("/emps")
    public Employee createEmployee(@RequestBody Employee emp) {
        return empservice.createEmployee(emp);
    }

    @DeleteMapping("/emps/{empid}")
    public String deleteEmpById(@PathVariable("empid") int empid) {
    	
        Optional<Employee> tempemp = empservice.findEmpById(empid);
        
        if (tempemp.isEmpty()) {
            throw new RuntimeException("Employee not found with id: " + empid);
        }
        empservice.deleteEmpById(empid);
        return "Employee with id " + empid + " deleted";
    }
}

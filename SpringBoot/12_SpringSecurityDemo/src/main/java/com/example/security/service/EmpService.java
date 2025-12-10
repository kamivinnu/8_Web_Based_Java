package com.example.security.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.security.entity.Employee;
import com.example.security.repository.EmpRepository;

@Service
public class EmpService {

    @Autowired
    private EmpRepository emprepo;

    public List<Employee> findAllEmployees() {
        return emprepo.findAll();
    }

    public Optional<Employee> findEmpById(int id) {
        return emprepo.findById(id);
    }

    public Employee createEmployee(Employee emp) {
        return emprepo.save(emp);
    }

    public void deleteEmpById(int id) {
        emprepo.deleteById(id);
    }
}

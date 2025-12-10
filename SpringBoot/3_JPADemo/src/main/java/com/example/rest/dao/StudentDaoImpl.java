package com.example.rest.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.rest.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class StudentDaoImpl implements StudentDao{
	
	// Injecting Entity Manager
	@Autowired
	private EntityManager entityManager;

	@Override
	@Transactional
	public void save(Student student) {
		entityManager.persist(student);
	}

	@Override
	public Student findById(Integer sid) {
		return entityManager.find(Student.class, sid);
	}

	@Override
	public List<Student> findAll() {
		TypedQuery<Student> query = entityManager.createQuery("from Student",Student.class);
	    List<Student> studs = query.getResultList();
	    return studs;
	}

	@Override
	@Transactional
	public void update(Student student) {
		entityManager.merge(student);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		Student student = entityManager.find(Student.class, id);
		entityManager.remove(student);
	}
	
	
}

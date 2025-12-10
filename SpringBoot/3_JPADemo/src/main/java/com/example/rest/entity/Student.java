package com.example.rest.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Entity class for ORM

@Entity
@Table(name="student")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int sid;
	private String sname;
	private double gpa;
}

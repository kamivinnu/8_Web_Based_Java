package com.example.StudentApp.pojos;

public class Student {
	
	private int sid;
	private String name;
	private double gpa;
	
	public Student(int sid, String name, double gpa) {
		super();
		this.sid = sid;
		this.name = name;
		this.gpa = gpa;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", name=" + name + ", gpa=" + gpa + "]";
	}

	
}

package com.gl.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="student")
public class Student {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	public Student(String fname, String lname, String course, String country) {
		super();
		this.fname = fname;
		this.lname = lname;
		Course = course;
		Country = country;
	}
public Student() {
		
	}
@Override
public String toString() {
	return "Student [id=" + id + ", fname=" + fname + ", lname=" + lname + ", Course=" + Course + ", Country=" + Country
			+ "]";
}
public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getCourse() {
		return Course;
	}
	public void setCourse(String course) {
		Course = course;
	}
	public String getCountry() {
		return Country;
	}
	public void setCountry(String country) {
		Country = country;
	}
@Column(name="fname")
 private String fname;
@Column(name="lname")
 private String lname;
@Column(name="course")
 private String Course;
@Column(name="country")
 private String Country;
 
}

package com.gl.service;

import java.util.List;

import com.gl.entity.Student;

public interface StudentService {
	
	public List<Student> findAll();
	public void save(Student student);
	public void deleteByTn(int id);
	public Student findById(int id);

}

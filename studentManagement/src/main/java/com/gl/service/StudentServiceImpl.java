package com.gl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gl.entity.Student;

import jakarta.transaction.Transactional;

public class StudentServiceImpl implements StudentService {
	@Autowired
	private com.gl.dao.studentRepository studentRepository;

	@Transactional
	public List<Student> findAll() {
		return studentRepository.findAll();
	}

	@Transactional
	public void save(Student student) {
		studentRepository.save(student);

	}

	@Transactional
	public void deleteByTn(int id) {
		studentRepository.deleteById(id);

	}

	@Transactional
	public Student findById(int id) {
		Student student = studentRepository.findById(id).get();
		if (student == null)
			throw new RuntimeException("Cannot find the student" + id);
		else
			return student;
	}

}

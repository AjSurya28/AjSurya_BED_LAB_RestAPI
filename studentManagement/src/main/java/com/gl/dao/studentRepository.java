package com.gl.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gl.entity.Student;

public interface studentRepository extends JpaRepository<Student,Integer> {
}

package com.interview.service;

import java.util.List;

import com.interview.model.Student;

public interface StudentService {

	long save(Student student);
	List<Student> list();
	void update(long id,Student student);
}

package com.interview.dao;

import java.util.List;

import com.interview.model.Student;

public interface StudentDao {

	long save(Student student);
	List<Student> list();
	void update(long id,Student student);
}

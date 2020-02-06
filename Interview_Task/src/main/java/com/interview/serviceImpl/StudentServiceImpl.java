package com.interview.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.interview.dao.StudentDao;
import com.interview.model.Student;
import com.interview.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	@Qualifier("StudentDao")
	private StudentDao studentDao;
	
	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	@Transactional
	@Override
	public long save(Student student) {
		// TODO Auto-generated method stub
		return studentDao.save(student);
	}

	@Override
	public List<Student> list() {
		// TODO Auto-generated method stub
		return studentDao.list();
	}

	@Override
	public void update(long id,Student student) {
		// TODO Auto-generated method stub
		studentDao.update(id,student);
	}

}

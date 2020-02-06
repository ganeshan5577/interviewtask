package com.interview.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.interview.dao.StudentDao;
import com.interview.model.Student;

@Transactional(readOnly = true)
@Repository
public class StudentDaoImpl implements StudentDao{

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
	this.sessionFactory = sf;
	}
	
	@Transactional
	@Override
	public long save(Student student) {
		//sessionFactory.getCurrentSession().save(student);
		Session session=sessionFactory.getCurrentSession();
		   Transaction trans=session.beginTransaction();
		   session.save(student);
		   trans.commit();
	return student.getId();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Student> list() {
		Session session = sessionFactory.getCurrentSession();		
		session.beginTransaction();
		List<Student> countryList = session.createQuery("from Student").list();
		session.getTransaction().commit();
		return countryList;
	}

	@Transactional
	@Override
	public void update(long id,Student student) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Student student1 = (Student) session.get(Student.class, id);
		student1.setFirst_Name(student.getFirst_Name());
		student1.setLast_Name(student.getLast_Name());
		student1.setAge(student.getAge());
		student1.setDateofbirth(student.getDateofbirth());
		student1.setAddress(student.getAddress());
		student1.setCity(student.getCity());
		student1.setState(student.getState());
		student1.setCountry(student.getCountry());
	    session.flush();
	    tx.commit();
	}

}

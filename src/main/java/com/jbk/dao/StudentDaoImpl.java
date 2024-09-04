package com.jbk.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jbk.entity.Student;

@Repository
public class StudentDaoImpl implements StudentDao {
	@Autowired
	private SessionFactory factory;

	@Override
	public String addStudent(Student student) {

		Session session = null;

		try {
			session = factory.openSession();
			session.save(student);
			session.beginTransaction().commit();
			return "Data Added";

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return null;
	}

	@Override
	public List<Student> getAllStudent() {
		Session session = null;
		List<Student> list = null;
		try {
			session = factory.openSession();
			Criteria criteria = session.createCriteria(Student.class);
			list = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}

	@Override
	public Student getStudentByRollNo(long rollNo) {
		Session session = null;
		Student student = null;
		try {
			session = factory.openSession();
			student = session.get(Student.class, rollNo);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return student;
	}

	@Override
	public String updateStudent(Student student) {
		Session session = null;
		String msg;
		try {
			session = factory.openSession();
			session.update(student);
			session.beginTransaction().commit();
			msg = "Updated Successfully";

		} catch (Exception e) {
			e.printStackTrace();
			msg = "Something went wrong during update student";
		}
		return msg;
	}

	@Override
	public String deleteStudent(long rollNo) {
		Session session = null;
		String msg;
		try {
			session = factory.openSession();
			Student student = session.get(Student.class, rollNo);
			session.delete(student);
			session.beginTransaction().commit();
			msg = "deleted successfully";
		} catch (Exception e) {
			e.printStackTrace();
			msg = "Something went wrong during delete student";
		} finally {
			session.close();
		}
		return msg;
	}

	@Override
	public List<Student> getAllStudentByRoll(List<Long> list) {
		Session session = null;
		List<Student> studentList = null;
		try {
			session = factory.openSession();
			studentList = session.byMultipleIds(Student.class).multiLoad(list);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return studentList;
	}

}

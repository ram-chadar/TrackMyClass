package com.jbk.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jbk.entity.Subject;

@Repository
public class SubjectDaoImpl implements SubjectDao {
	@Autowired
	private SessionFactory factory;

	@Override
	public String addSubject(Subject subject) {

		Session session = null;

		try {
			session = factory.openSession();
			session.save(subject);
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
	public List<Subject> getAllSubject() {
		Session session = null;
		List<Subject> list = null;
		try {
			session = factory.openSession();
			Criteria criteria = session.createCriteria(Subject.class);
			list = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}

	@Override
	public Subject getSubjectByRollNo(long rollNo) {
		Session session = null;
		Subject subject = null;
		try {
			session = factory.openSession();
			subject = session.get(Subject.class, rollNo);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return subject;
	}

	@Override
	public String updateSubject(Subject subject) {
		Session session = null;
		String msg;
		try {
			session = factory.openSession();
			session.update(subject);
			session.beginTransaction().commit();
			msg = "Updated Successfully";

		} catch (Exception e) {
			e.printStackTrace();
			msg = "Something went wrong during update subject";
		}
		return msg;
	}

	@Override
	public String deleteSubject(long rollNo) {
		Session session = null;
		String msg;
		try {
			session = factory.openSession();
			Subject subject = session.get(Subject.class, rollNo);
			session.delete(subject);
			session.beginTransaction().commit();
			msg = "deleted successfully";
		} catch (Exception e) {
			e.printStackTrace();
			msg = "Something went wrong during delete subject";
		} finally {
			session.close();
		}
		return msg;
	}

}

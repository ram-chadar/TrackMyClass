package com.jbk.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jbk.entity.User;

@Repository
public class UserDaoImpl implements UserDao {
	@Autowired
	private SessionFactory factory;

	@Override
	public String addUser(User user) {

		Session session = null;

		try {
			session = factory.openSession();
			session.save(user);
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
	public List<User> getAllUser() {
		Session session = null;
		List<User> list = null;
		try {
			session = factory.openSession();
			Criteria criteria = session.createCriteria(User.class);
			list = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}

	@Override
	public User getUserByUsername(String username) {
		Session session = null;
		User user = null;
		try {
			session = factory.openSession();
			user = session.get(User.class, username);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return user;
	}

	@Override
	public String updateUser(User user) {
		Session session = null;
		String msg;
		try {
			session = factory.openSession();
			session.update(user);
			session.beginTransaction().commit();
			msg = "Updated Successfully";

		} catch (Exception e) {
			e.printStackTrace();
			msg = "Something went wrong during update user";
		}
		return msg;
	}

	@Override
	public String deleteUser(String username) {
		Session session = null;
		String msg;
		try {
			session = factory.openSession();
			User user = session.get(User.class, username);
			session.delete(user);
			session.beginTransaction().commit();
			msg = "deleted successfully";
		} catch (Exception e) {
			e.printStackTrace();
			msg = "Something went wrong during delete user";
		} finally {
			session.close();
		}
		return msg;
	}

}

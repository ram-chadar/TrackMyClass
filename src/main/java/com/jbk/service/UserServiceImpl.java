package com.jbk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbk.dao.UserDao;
import com.jbk.entity.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao dao;

	@Override
	public String addUser(User user) {
		
		String msg = dao.addUser(user);
		
		return msg;
	}

	@Override
	public List<User> getAllUser() {
		List<User> allUser = dao.getAllUser();
		return allUser;
	}

	@Override
	public User getUserByUsername(String username) {
		User user = dao.getUserByUsername(username);
		return user;
	}

	@Override
	public String updateUser(User user) {
		String msg = dao.updateUser(user);
		return msg;
	}

	@Override
	public String deleteUser(String username) {
		String msg = dao.deleteUser(username);
		return msg;
	}

}

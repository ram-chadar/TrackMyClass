package com.jbk.dao;

import java.util.List;

import com.jbk.entity.User;

public interface UserDao {

	public String addUser(User user);

	public List<User> getAllUser();

	public User getUserByUsername(String username);

	public String updateUser(User user);

	public String deleteUser(String username);
}

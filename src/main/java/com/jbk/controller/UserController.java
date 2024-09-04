package com.jbk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.entity.User;
import com.jbk.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService service;

	@GetMapping("/get-all-users")
	public List<User> getAllUser() {
		List<User> allUser = service.getAllUser();
		return allUser;
	}

	// localhost:8091/user/add-user
	@PostMapping("/add-user")
	public String addUser(@RequestBody User user) {

		String msg = service.addUser(user);
		return msg;
	}

	@GetMapping("/get-user-by-username/{username}")
	public User getUserByRollNo(@PathVariable String username) {
		User user = service.getUserByUsername(username);
		return user;

	}

	@DeleteMapping("/delete-user/{username}")
	public String deleteStudet(@PathVariable String username) {
		String msg = service.deleteUser(username);
		return msg;
	}

	@PutMapping("/update-user")
	public String updateUser(@RequestBody User user) {
		String msg = service.updateUser(user);
		return msg;
	}
}

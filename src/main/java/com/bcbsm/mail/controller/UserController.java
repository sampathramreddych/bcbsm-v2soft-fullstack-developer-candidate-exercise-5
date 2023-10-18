package com.bcbsm.mail.controller;

import com.bcbsm.mail.model.UserModel;
import com.bcbsm.mail.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RequestMapping("/users")
@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/{username}")
	public UserModel getUser(@PathVariable String username) {
		UserModel user = userService.getUser(username);
		System.out.println(" user :: " + user);
		return user;
	}

	@PostMapping
	public String addUser(@RequestBody UserModel user) {
		return userService.addUser(user);
	}

}

package com.zacharychao.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zacharychao.user.entity.User;
import com.zacharychao.user.service.UserService;

@Controller
@RequestMapping(value="/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("/register")
	public void register(String username,String password) {
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		userService.register(user);
	}
}

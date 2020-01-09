package com.zacharychao.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zacharychao.user.dao.UserDao;
import com.zacharychao.user.entity.User;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	public boolean register(User user) {
		User u = userDao.findByUsername(user.getUsername());
		if(u.getId() == null) {
			userDao.register(user);
            return true;
		}
		return false;
	}
	
	public User getUserByUsername(String username) {
		return userDao.findByUsername(username);
	}
}

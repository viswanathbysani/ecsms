package com.ecs.register.registration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ecs.register.registration.model.User;

@Component
public class LoginService {
	
	@Autowired
	UserService userService;
	
	public User login (User userObj)
	{
		User user = userService.getUserByName(userObj.getUsername());
		if (user != null && userObj.getPassword().equals(user.getPassword()))
		{
			
			return user;
		}
		return userObj;
		
	}
}

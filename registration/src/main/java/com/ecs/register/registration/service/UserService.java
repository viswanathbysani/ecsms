package com.ecs.register.registration.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ecs.register.registration.model.User;

@Component
public class UserService {
	
	@Autowired
	UserRepository repo;
	
	public User registerUser(User user)
	{
		repo.save(user);
		return user;
	}
	
	public User getUserByName(String username)
	{
		return repo.findByusername(username);
	}
	
	public List<User> getAllMembers()
	{
		return repo.isMember(true);
	}
}

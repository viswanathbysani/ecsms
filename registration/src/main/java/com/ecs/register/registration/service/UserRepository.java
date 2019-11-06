package com.ecs.register.registration.service;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ecs.register.registration.model.User;



public interface UserRepository extends MongoRepository<User, String>{ 
	
	public User findByusername(String name);
	
	public List<User> isMember(boolean member);
}

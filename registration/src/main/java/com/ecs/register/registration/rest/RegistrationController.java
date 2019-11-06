package com.ecs.register.registration.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.ecs.register.registration.model.User;
import com.ecs.register.registration.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;

@Controller
@EnableWebMvc
@CrossOrigin("*")
@RequestMapping("/api/ecs")
public class RegistrationController {
	
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	UserService service;
	
	@PutMapping(path="/registration" , consumes = "application/json",  produces="application/json")
	public @ResponseBody User add(@RequestBody User user)
	{
		service.registerUser(user);
		return user;
	}
	
	@GetMapping(path="/byName/{username}", produces="application/json")
	public @ResponseBody User getUserByUserName(@PathVariable("username") String userName) throws JsonProcessingException
	{
		User user = service.getUserByName(userName);
		System.out.println(user.toString());
		return user;
	}
	
	@GetMapping(path="/members", produces="application/json")
	public @ResponseBody List<User> getAllMembers() throws JsonProcessingException
	{
		return service.getAllMembers();
	}
	
}

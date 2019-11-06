package com.ecs.register.registration.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.ecs.register.registration.model.User;
import com.ecs.register.registration.service.LoginService;

@Controller
@EnableWebMvc
@CrossOrigin("*")
@RequestMapping("/api/ecs")
public class LoginController {
	
	@Autowired
	LoginService loginSer;
	
	@PostMapping(path="/login" , consumes = "application/json", produces="application/json")
	public @ResponseBody User login(@RequestBody User user)
	{
		System.out.println("name >> " + user.getUsername());
		System.out.println("name >> " + user.getPassword());
		User loggedinUser = loginSer.login(user);
		if ( null != loggedinUser.getEmail())
			return loggedinUser;
		else
			return user;
	}

}

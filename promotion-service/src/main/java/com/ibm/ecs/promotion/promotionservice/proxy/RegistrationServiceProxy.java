package com.ibm.ecs.promotion.promotionservice.proxy;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.ibm.ecs.promotion.promotionservice.model.User;

@FeignClient(name="registration")
public interface RegistrationServiceProxy {

	@GetMapping(value="/api/ecs/members", produces = "application/json")
	public List<User> getMembers();
	
}



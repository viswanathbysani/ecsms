package com.ibm.ecs.promotion.promotionservice.rest;

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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ibm.ecs.promotion.promotionservice.model.Promotion;
import com.ibm.ecs.promotion.promotionservice.proxy.RegistrationServiceProxy;
import com.ibm.ecs.promotion.promotionservice.service.PromotionService;

@Controller
@EnableWebMvc
@CrossOrigin("*")
@RequestMapping("/api/ecs/promotion")
public class PromotionController {

	@Autowired
	PromotionService service;
	

	
	@GetMapping(path="/byCode/{code}", produces="application/json")
	public @ResponseBody Promotion getPromotionByCode(@PathVariable("code") String code) throws JsonProcessingException
	{
		return service.getPromotionByCode(code);
	}
	
	@PutMapping(path="/save", produces="application/json")
	public @ResponseBody void addPromotion(@RequestBody Promotion promotion) throws JsonProcessingException
	{
		service.savePromotion(promotion);
		//System.out.println("No. of members >>" + proxy.getMembers().size());
	}

}

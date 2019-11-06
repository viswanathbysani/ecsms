package com.ibm.ecs.promotion.promotionservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ibm.ecs.promotion.promotionservice.model.Promotion;
import com.ibm.ecs.promotion.promotionservice.model.User;
import com.ibm.ecs.promotion.promotionservice.proxy.RegistrationServiceProxy;

@Component
public class PromotionService {
	@Autowired
	PromotionRepository promoRepo;
	
	@Autowired
	RegistrationServiceProxy proxy;
	
	public void savePromotion(Promotion promotion)
	{
		promoRepo.save(promotion);
		// Get all members and send email about promotion
		List<User> users = proxy.getMembers();
		for (User user:users)
		{
			//send mail
			System.out.println("Send mail to >>" + user.getEmail() + " about promotion :" + promotion.getCode() );
		}
	}
	
	public Promotion getPromotionByCode(String promoCode)
	{
		return promoRepo.findByCode(promoCode);
	}
}

package com.ibm.ecs.promotion.promotionservice.service;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ibm.ecs.promotion.promotionservice.model.Promotion;

public interface PromotionRepository extends MongoRepository<Promotion, String> {

	Promotion findByCode(String promoCode);

}

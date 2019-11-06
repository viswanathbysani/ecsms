package com.ibm.ecs.inventoryservice.service;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.ibm.ecs.inventoryservice.model.Product;

public interface ProductRepository extends PagingAndSortingRepository <Product,String>{
	
	public List<Product> findByNameOrDescription(String name, String desc);

}

package com.ibm.ecs.inventoryservice.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import com.ibm.ecs.inventoryservice.model.Order;
import com.ibm.ecs.inventoryservice.model.Product;

@Component
public class ProductService {

	@Autowired
	ProductRepository repo;
	
	public List<Product> getAllProducts()
	{
		Sort sort = new Sort(Sort.Direction.ASC,"name");
		
		Iterable<Product> iterator = repo.findAll(sort);
		
		Collection<Product> sortedProducts = new ArrayList<Product>();
		
		iterator.forEach(sortedProducts::add);
		
		return (List<Product>)sortedProducts;
	}

	public void addOrUpdateProduct(Product product) {
		repo.save(product);
	}

	public List<Product> getProductByNameorDesc(String nameOrDesc) {
		return repo.findByNameOrDescription(nameOrDesc,nameOrDesc);
	}
	
	public Product getProductByID(String productId)
	{
		Optional<Product> product = repo.findById(productId);
		Product productFound=null;
		if (product.isPresent())
		{
			productFound=product.get();
		}
		return productFound;
	}

	public void processOrder(Order order) {
		/*System.out.println("product id >>>" + order.getProductIds() );
		System.out.println("promotion percentage >>>" + order.getPromotion() );
		System.out.println("card no >>> " + order.getCardNo());*/
		//System.out.println("user Name >>" + order.getUserName());
		String productIds = order.getProductIds();
		productIds = productIds.substring(0,productIds.length()-1);
		String[] productIdsArray = productIds.split(",");
	
		Product product;
		for (int i=0; i< productIdsArray.length; i++)
		{
			product = getProductByID(productIdsArray[i]);
			product.setStock(product.getStock()-1);
			addOrUpdateProduct(product);
		}
		
	}
}

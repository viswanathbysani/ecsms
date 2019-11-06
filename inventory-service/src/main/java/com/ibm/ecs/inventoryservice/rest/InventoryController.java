package com.ibm.ecs.inventoryservice.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ibm.ecs.inventoryservice.model.Order;
import com.ibm.ecs.inventoryservice.model.Product;
import com.ibm.ecs.inventoryservice.service.ProductService;

@Controller
@EnableWebMvc
@CrossOrigin("*")
@RequestMapping("/api/ecs/inventory")
public class InventoryController {

	@Autowired
	ProductService service;
	
	@GetMapping(path="/products", produces="application/json")
	public @ResponseBody List<Product> getAllProducts() throws JsonProcessingException
	{
		return service.getAllProducts();
	}
	
	@GetMapping(path="/products/byNameorDesc/{nameOrDesc}", produces="application/json")
	public @ResponseBody List<Product> getProductbyNameorDescription(@PathVariable("nameOrDesc") String nameOrDesc) throws JsonProcessingException
	{
		return service.getProductByNameorDesc(nameOrDesc);
	}
	
	@GetMapping(path="/products/byId/{id}", produces="application/json")
	public @ResponseBody Product getProductbyID(@PathVariable("id") String id) throws JsonProcessingException
	{
		return service.getProductByID(id);
	}
	
	@PutMapping(path="/products", produces="application/json")
	public @ResponseBody void addProduct(@RequestBody Product product) throws JsonProcessingException
	{
		service.addOrUpdateProduct(product);
	}
	
	@PostMapping(path="/processorder", produces="application/json")
	public @ResponseBody void processOrder(@RequestBody Order order)
	
	{
		service.processOrder(order);
	}
	
}

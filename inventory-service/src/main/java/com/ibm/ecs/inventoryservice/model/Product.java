package com.ibm.ecs.inventoryservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "products")
public class Product {

	  @Id
	  public String ID;
	  public String name;
	  public String description;
	  public Double price;
	  public int reorderThreshhold;
	  public boolean stopOrder;
	  public int stock;
	@Override
	public String toString() {
		return "Product [ID=" + ID + ", name=" + name + ", description=" + description + ", price=" + price
				+ ", reorderThreshhold=" + reorderThreshhold + ", stopOrder=" + stopOrder + ", stock=" + stock + "]";
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public int getReorderThreshhold() {
		return reorderThreshhold;
	}
	public void setReorderThreshhold(int reorderThreshhold) {
		this.reorderThreshhold = reorderThreshhold;
	}
	public boolean isStopOrder() {
		return stopOrder;
	}
	public void setStopOrder(boolean stopOrder) {
		this.stopOrder = stopOrder;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
}

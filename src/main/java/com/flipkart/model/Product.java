package com.flipkart.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


public class Product implements Serializable {
	
	private int productId;
	
	private String productName;
	
	private double price;
		
	private Brand brand;
	
	private Set<Category> categories = new HashSet<>();

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public Set<Category> getCategories() {
		return categories;
	}

	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}
	
	
}

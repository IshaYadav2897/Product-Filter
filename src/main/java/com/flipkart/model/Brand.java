package com.flipkart.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Brand implements Serializable {

	private int brandId;
	
	private String brandName;
	
	private Set<Product> products = new HashSet<>();
	
	public int getBrandId() {
		return brandId;
	}

	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	
}

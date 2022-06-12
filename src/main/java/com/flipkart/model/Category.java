package com.flipkart.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Category implements Serializable {

	private int categoryId;
	
	private String categoryName;
	
	private Integer parentId;
	
	private Set<Product> products = new HashSet<>();

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
			this.parentId = parentId;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	
	
}

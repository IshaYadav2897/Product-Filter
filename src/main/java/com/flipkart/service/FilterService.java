package com.flipkart.service;

import java.util.List;

import com.flipkart.exception.ProductNotFoundException;
import com.flipkart.model.FilterCriteria;
import com.flipkart.model.Product;

public interface FilterService {

	public List<Product> getProducts(FilterCriteria criteria) throws ProductNotFoundException;
	
	public List<Product> getRootCategorizedProducts(int categoryId) throws ProductNotFoundException;

	//	public List<Product> getProducts();
}

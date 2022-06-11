package com.flipkart.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flipkart.exception.ProductNotFoundException;
import com.flipkart.model.FilterCriteria;
import com.flipkart.model.Product;
import com.flipkart.service.FilterService;

@RestController
@RequestMapping("/api/v1/flipkart")
public class FilterController {

	private static final Logger logger = LoggerFactory.getLogger(FilterController.class);
	
	@Autowired
	private FilterService filterService;
	
	@GetMapping(value = "/products")
	public List<Product> getProducts(FilterCriteria filterCriteria) throws ProductNotFoundException{
		return filterService.getProducts(filterCriteria);
	}
	
	@GetMapping(value = "/products/clearAll")
	public List<Product> getRootCategorizedProducts(int categoryId) throws ProductNotFoundException{
		return filterService.getRootCategorizedProducts(categoryId);
	}
}

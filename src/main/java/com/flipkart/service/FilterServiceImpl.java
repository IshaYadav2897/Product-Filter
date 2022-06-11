package com.flipkart.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flipkart.exception.ProductNotFoundException;
import com.flipkart.model.Brand;
import com.flipkart.model.FilterCriteria;
import com.flipkart.model.Product;
import com.flipkart.repo.FilterRepository;

@Service
public class FilterServiceImpl implements FilterService {
	
	private static final Logger logger = LoggerFactory.getLogger(FilterServiceImpl.class);
	
	@Autowired
	private FilterRepository filterRepository;

	@Override
	public List<Product> getProducts(FilterCriteria filterCriteria) throws ProductNotFoundException{
		String brands = filterCriteria.getBrands().toString().substring(1, filterCriteria.getBrands().toString().length()-1);
		List<Product> products = filterRepository.getProducts(filterCriteria.getRootCategoryId(), brands);
		logger.info("Successfully fetched + " + products.size() + " products");
		if (products.isEmpty())
			throw new ProductNotFoundException("No Products found");
		return products;
//		return filterRepository.findAll();
	}

	@Override
	public List<Product> getRootCategorizedProducts(int categoryId) throws ProductNotFoundException {
		List<Product> products = filterRepository.getCategorizedProducts(categoryId);
		logger.info("Successfully fetched + " + products.size() + " products");
		if (products.isEmpty())
			throw new ProductNotFoundException("No Products found");
		return products;
	}
	
}

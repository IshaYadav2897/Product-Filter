package com.flipkart.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flipkart.exception.InvalidFilterCriteriaException;
import com.flipkart.exception.ProductNotFoundException;
import com.flipkart.model.Brand;
import com.flipkart.model.Category;
import com.flipkart.model.FilterCriteria;
import com.flipkart.model.Product;
import com.flipkart.repo.JDBCFilterRepository;
import com.flipkart.util.FlipkartUtil;

@Service
public class FilterServiceImpl implements FilterService {
	
	private static final Logger logger = LoggerFactory.getLogger(FilterServiceImpl.class);
		
	@Autowired
	private JDBCFilterRepository jdbcFilterRepository;

	@Override
	public List<Product> getProducts(FilterCriteria filterCriteria) throws ProductNotFoundException, InvalidFilterCriteriaException {
		if (FlipkartUtil.invalidFilterCriteria(filterCriteria))
			throw new InvalidFilterCriteriaException("Please provide valid filter criteria");
		String brands = null, offers = null;
		if (!filterCriteria.getBrands().isEmpty())
			brands = filterCriteria.getBrands().toString().substring(1, filterCriteria.getBrands().toString().length()-1);
		if (!filterCriteria.getOffers().isEmpty())
			offers = filterCriteria.getOffers().toString().substring(1, filterCriteria.getOffers().toString().length()-1);
		logger.info("brands: " + brands);
		List<Product> products = jdbcFilterRepository.getProducts(filterCriteria.getRootCategoryId(), 
				brands, filterCriteria.getMinPrice(), filterCriteria.getMaxPrice(), filterCriteria.getAvailabileYN(),
				filterCriteria.getGstInvoiceAvailableYN(), filterCriteria.getfAssuredYN(), offers,
				filterCriteria.getMinRating());
		logger.info("Successfully fetched " + products.size() + " products");
		if (products.isEmpty())
			throw new ProductNotFoundException("No Products found");
		return products;
	}

	@Override
	public List<Product> getRootCategorizedProducts(int categoryId) throws ProductNotFoundException {
		List<Product> products = jdbcFilterRepository.getCategorizedProducts(categoryId);
		logger.info("Successfully fetched " + products.size() + " products");
		if (products.isEmpty())
			throw new ProductNotFoundException("No Products found");
		return products;
	}

	@Override
	public List<Category> getCategoriesById(int categoryId) {
		List<Category> categories = jdbcFilterRepository.getCategoriesById(categoryId);
		logger.info("Successfully fetched " + categories.size() + " categories");
		return categories;
	}

	@Override
	public List<Brand> getBrandsByCategoryId(int categoryId) {
		List<Brand> brands = jdbcFilterRepository.getBrandsByCategoryId(categoryId);
		logger.info("Successfully fetched " + brands.size() + " brands");
		return brands;
	}
	
}

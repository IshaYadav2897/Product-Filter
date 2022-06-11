package com.flipkart.model;

import java.util.List;

public class FilterCriteria {
	
	private int rootCategoryId;
	private int subCategoryId;
	private double minPrice;
	private double maxPrice;
	private String isfAssured;
	private String isAvailabile;
	private List<Integer> brands;
	private List<Integer> offers;
	private String isGstInvoiceAvailable;
	private Double minRating;
	
	public int getRootCategoryId() {
		return rootCategoryId;
	}
	public void setRootCategoryId(int rootCategoryId) {
		this.rootCategoryId = rootCategoryId;
	}
	public int getSubCategoryId() {
		return subCategoryId;
	}
	public void setSubCategoryId(int subCategoryId) {
		this.subCategoryId = subCategoryId;
	}
	public double getMinPrice() {
		return minPrice;
	}
	public void setMinPrice(double minPrice) {
		this.minPrice = minPrice;
	}
	public double getMaxPrice() {
		return maxPrice;
	}
	public void setMaxPrice(double maxPrice) {
		this.maxPrice = maxPrice;
	}
	public String getIsfAssured() {
		return isfAssured;
	}
	public void setIsfAssured(String isfAssured) {
		this.isfAssured = isfAssured;
	}
	public String getIsAvailabile() {
		return isAvailabile;
	}
	public void setIsAvailabile(String isAvailabile) {
		this.isAvailabile = isAvailabile;
	}
	public List<Integer> getBrands() {
		return brands;
	}
	public void setBrands(List<Integer> brands) {
		this.brands = brands;
	}
	public List<Integer> getOffers() {
		return offers;
	}
	public void setOffers(List<Integer> offers) {
		this.offers = offers;
	}
	public String getIsGstInvoiceAvailable() {
		return isGstInvoiceAvailable;
	}
	public void setIsGstInvoiceAvailable(String isGstInvoiceAvailable) {
		this.isGstInvoiceAvailable = isGstInvoiceAvailable;
	}
	public Double getMinRating() {
		return minRating;
	}
	public void setMinRating(Double minRating) {
		this.minRating = minRating;
	}
	
}

package com.flipkart.model;

import java.util.List;

public class FilterCriteria {
	
	private int rootCategoryId;
//	private int subCategoryId;
	private double minPrice;
	private double maxPrice;
	private boolean fAssuredYN;
	private boolean availabileYN;
	private List<Integer> brands;
	private List<Integer> offers;
	private boolean gstInvoiceAvailableYN;
	private Double minRating;
	
	public int getRootCategoryId() {
		return rootCategoryId;
	}
	public void setRootCategoryId(int rootCategoryId) {
		this.rootCategoryId = rootCategoryId;
	}
//	public int getSubCategoryId() {
//		return subCategoryId;
//	}
//	public void setSubCategoryId(int subCategoryId) {
//		this.subCategoryId = subCategoryId;
//	}
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
	public Boolean getfAssuredYN() {
		return fAssuredYN;
	}
	public void setfAssuredYN(Boolean fAssuredYN) {
		this.fAssuredYN = fAssuredYN;
	}
	public Boolean getAvailabileYN() {
		return availabileYN;
	}
	public void setAvailabileYN(Boolean availabileYN) {
		this.availabileYN = availabileYN;
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
	public Boolean getGstInvoiceAvailableYN() {
		return gstInvoiceAvailableYN;
	}
	public void setGstInvoiceAvailableYN(Boolean gstInvoiceAvailableYN) {
		this.gstInvoiceAvailableYN = gstInvoiceAvailableYN;
	}
	public Double getMinRating() {
		return minRating;
	}
	public void setMinRating(Double minRating) {
		this.minRating = minRating;
	}
	
	
	
	
}

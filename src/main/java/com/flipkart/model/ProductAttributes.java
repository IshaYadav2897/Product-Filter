package com.flipkart.model;

import java.io.Serializable;

public class ProductAttributes implements Serializable {
	
	private int attributeId;
	
	private Product product;
	
	private boolean avaiableYN;
	
	private boolean gstAvailableYN;
	
	private boolean fAssuredYN;
	
	private double customerRating;
	
	private String status;
	
	private String imagePath;
	
	public int getAttributeId() {
		return attributeId;
	}

	public void setAttributeId(int attributeId) {
		this.attributeId = attributeId;
	}

	public boolean isAvaiableYN() {
		return avaiableYN;
	}

	public void setAvaiableYN(boolean avaiableYN) {
		this.avaiableYN = avaiableYN;
	}

	public boolean isGstAvailableYN() {
		return gstAvailableYN;
	}

	public void setGstAvailableYN(boolean gstAvailableYN) {
		this.gstAvailableYN = gstAvailableYN;
	}

	public boolean isfAssuredYN() {
		return fAssuredYN;
	}

	public void setfAssuredYN(boolean fAssuredYN) {
		this.fAssuredYN = fAssuredYN;
	}

	public double getCustomerRating() {
		return customerRating;
	}

	public void setCustomerRating(double customerRating) {
		this.customerRating = customerRating;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	
}

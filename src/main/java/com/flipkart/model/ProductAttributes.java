package com.flipkart.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "product_attributes")
public class ProductAttributes {
	
	@Id
	@Column(name = "attribute_id")
	private int attributeId;
	
	@Column(name = "is_available")
	private boolean avaiableYN;
	
	@Column(name = "gst_available")
	private boolean gstAvailableYN;
	
	@Column(name = "is_fassured")
	private boolean fAssuredYN;
	
	@Column(name = "customer_rating")
	private double customerRating;
	
	@Column(name = "status")
	private String status;
	
	@OneToOne()
	@JoinColumn(name = "productId", referencedColumnName = "product_id")
	private Product product;
	
	@ManyToMany(fetch = FetchType.EAGER,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
                })
	@JoinTable(name = "product_attributes_offer", 
			  joinColumns = @JoinColumn(name = "product_id"), 
			  inverseJoinColumns = @JoinColumn(name = "offer_id"))
	private Set<Offer> offers = new HashSet<>();

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

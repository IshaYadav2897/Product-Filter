package com.flipkart.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Offer implements Serializable {
	
	private int offerId;
	
	private String offerName;
	
	private Set<ProductAttributes> productAttributes = new HashSet<>();

	public int getOfferId() {
		return offerId;
	}

	public void setOfferId(int offerId) {
		this.offerId = offerId;
	}

	public String getOfferName() {
		return offerName;
	}

	public void setOfferName(String offerName) {
		this.offerName = offerName;
	}
	
	
}

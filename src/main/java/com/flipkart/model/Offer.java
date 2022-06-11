package com.flipkart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "offer")
public class Offer {
	
	@Id
	@Column(name = "offer_id")
	private int offerId;
	
	@Column(name = "offer_name")
	private String offerName;

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

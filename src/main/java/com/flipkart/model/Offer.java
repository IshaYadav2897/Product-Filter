package com.flipkart.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "offer")
public class Offer implements Serializable {
	
	@Id
	@Column(name = "offer_id")
	private int offerId;
	
	@Column(name = "offer_name")
	private String offerName;
	
	@ManyToMany(mappedBy = "offers"
			, fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE,
                })
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

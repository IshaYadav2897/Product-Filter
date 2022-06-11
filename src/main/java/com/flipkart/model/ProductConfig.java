package com.flipkart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "product_config")
public class ProductConfig {

	@Id
	@Column(name = "config_id")
	private int productConfigId;
	
	@Column(name = "config_type")
	private String configType;
	
	@Column(name = "config_value")
	private String configValue;
	
	@Column(name = "status")
	private String status;
	
	@OneToOne()
	@JoinColumn(name = "productId", referencedColumnName = "product_id")
	private Product product;

	public int getProductConfigId() {
		return productConfigId;
	}

	public void setProductConfigId(int productConfigId) {
		this.productConfigId = productConfigId;
	}

	public String getConfigType() {
		return configType;
	}

	public void setConfigType(String configType) {
		this.configType = configType;
	}

	public String getConfigValue() {
		return configValue;
	}

	public void setConfigValue(String configValue) {
		this.configValue = configValue;
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

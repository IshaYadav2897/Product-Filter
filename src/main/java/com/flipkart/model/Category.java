package com.flipkart.model;

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
@Table(name = "category")
public class Category {

	@Id
	@Column(name = "category_id")
	private int categoryId;
	
	@Column(name = "category_name")
	private String categoryName;
	
	@Column(name = "parent_id")
	private Integer parentId;
	
//	@ManyToMany
//	@JoinTable(name = "category_brand", 
//			  joinColumns = @JoinColumn(name = "category_id"), 
//			  inverseJoinColumns = @JoinColumn(name = "brand_id"))
//	private Set<Brand> brands;
	
	@ManyToMany(mappedBy = "categories"
			, fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE,
                })
	private Set<Product> products = new HashSet<>();

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
			this.parentId = parentId;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	
	
}

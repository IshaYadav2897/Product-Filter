package com.flipkart.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.flipkart.model.Product;

@Repository
public interface FilterRepository extends JpaRepository<Product, Integer> {

	public static final String FILTERED_PRODUCTS_QUERY = 
			"select distinct p.product_id, p.product_name, p.price, p.brand_id \r\n" + 
					"from product p\r\n" + 
					"left join product_config pc\r\n" + 
					"	on p.product_id = pc.product_id\r\n" + 
					"join brand b\r\n" + 
					"	on p.brand_id = b.brand_id\r\n" + 
					"join product_category pca\r\n" + 
					"	on p.product_id = pca.product_id\r\n" + 
					"join category c\r\n" + 
					"	on pca.category_id = c.category_id\r\n";
	
	@Query(value = FILTERED_PRODUCTS_QUERY +
			" where c.category_id = ?1 \r\n" +
			"and (?2 is null or b.brand_id in (select value from string_split(?2,',')))", nativeQuery = true)
	public List<Product> getProducts(int rootCategoryId, String brands);
	
	@Query(value = "select distinct p.product_id, p.product_name, p.price, p.brand_id \r\n" + 
			"from product p\r\n" + 
			"join product_category pca\r\n" + 
			"	on p.product_id = pca.product_id\r\n" + 
			"join category c\r\n" + 
			"	on pca.category_id = c.category_id\r\n" +
			" where c.category_id = ?1 \r\n", nativeQuery = true)
	public List<Product> getCategorizedProducts(int categoryId);
}

package com.flipkart.repo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.flipkart.model.Brand;
import com.flipkart.model.Category;
import com.flipkart.model.Product;

@Repository
public class JDBCFilterRepository {

	private static final Logger logger = LoggerFactory.getLogger(JDBCFilterRepository.class);

//	private static final String INSERT_PRODUCT_QUERY =
//			"insert into product (product_id, product_name, price, brand_id) " 
//			+ "	values ( :product_id, :product_name, :price, :brand_id) ";
//	
	private static final String GET_FILTERED_PRODUCTS_QUERY = 
			"select distinct p.product_id, p.product_name, p.price, p.brand_id, b.brand_name " + 
			"from product p " + 
			"join brand b " + 
			"	on p.brand_id = b.brand_id " + 
			"join product_category pca " + 
			"	on p.product_id = pca.product_id " + 
			"join category c " + 
			"	on pca.category_id = c.category_id " + 
			"left join product_attributes pa " + 
			"	on p.product_id = pa.product_id " + 
			"left join product_attributes_offer pao " + 
			"	on pa.product_id = pao.product_id " + 
			"where c.category_id = :category_id  " +
			"and (:brands is null or b.brand_id in (select value from string_split(:brands,',')))" + 
			"and (:min_price is null or :max_price is null or p.price between :min_price and :max_price)" + 
			"and (:min_rating is null or pa.customer_rating >= :min_rating) " + 
			"and (:is_available is null or (pa.is_available = :is_available)) " + 
			"and (:is_gst_available is null or (pa.is_gst_available = :is_gst_available)) " + 
			"and (:is_fassured is null or (pa.is_fassured = :is_fassured)) " + 
			"and (:offers is null or pao.offer_id in (select value from string_split(:offers,','))) " + 
			"order by product_id desc " + 
			"offset 0 ROWS " + 
			"FETCH NEXT 5 ROWS ONLY ";
	
	private static final String GET_PRODUCTS_QUERY = 
			"select distinct p.product_id, p.product_name, p.price, p.brand_id, b.brand_name " + 
			"from product p " + 
			"join brand b " + 
			"	on p.brand_id = b.brand_id " + 
			"join product_category pca " + 
			"	on p.product_id = pca.product_id " + 
			"join category c " + 
			"	on pca.category_id = c.category_id " + 
			"where c.category_id = :category_id  " +
			"order by product_id desc " + 
			"offset 0 ROWS " + 
			"FETCH NEXT 5 ROWS ONLY ";
	
	private static final String GET_CATEGORIES_QUERY = 
			"select distinct c.category_id, c.category_name, c.parent_id " + 
			"from category c " + 
			"where c.category_id = :category_id or c.parent_id = :category_id ";
	
	private static final String GET_BRANDS_QUERY = 
			"select distinct b.brand_id, b.brand_name " + 
			"from product p\r\n" + 
			"join brand b\r\n" + 
			"	on p.brand_id = b.brand_id\r\n" + 
			"join product_category pca\r\n" + 
			"	on p.product_id = pca.product_id\r\n" + 
			"join category c\r\n" + 
			"	on pca.category_id = c.category_id " + 
			"where c.category_id = :category_id ";
	
	
	@Autowired
	private NamedParameterJdbcTemplate namedJdbcTemplate;
	
//	public int addEmplyee() {
//		
//		final MapSqlParameterSource params = new MapSqlParameterSource();
//		params.addValue("product_id", 14);
//		params.addValue("product_name", "White Jeans");
//		params.addValue("brand_id", "6");
//		params.addValue("price", "2999");
//
//	    return namedJdbcTemplate.update(
//	    		INSERT_PRODUCT_QUERY, params);
//	}
	
	public List<Product> getProducts(int rootCategoryId, String brands, double minPrice, double maxPrice,
			boolean isAvailable, boolean isGstAvailable, boolean isFassured, String offers, double minRating) {
				
		final MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("category_id", rootCategoryId);
		params.addValue("brands", brands);
		params.addValue("min_price", minPrice);
		params.addValue("max_price", maxPrice);
		params.addValue("is_available", isAvailable);
		params.addValue("is_gst_available", isGstAvailable);
		params.addValue("is_fassured", isFassured);
		params.addValue("offers", offers);
		params.addValue("min_rating", minRating);
				
		return namedJdbcTemplate.query(GET_FILTERED_PRODUCTS_QUERY, params, 
				(rs, rowNum) -> translateProduct(rs));
	}
	
	public List<Product> getCategorizedProducts(int categoryId) {
		final MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("category_id", categoryId);
		
		return namedJdbcTemplate.query(GET_PRODUCTS_QUERY, params, 
				(rs, rowNum) -> translateProduct(rs));
	}

	private Product translateProduct(ResultSet rs) throws SQLException{
		int columnIndex = 1;
		Product product = new Product();
		Brand brand = new Brand();
			product.setProductId(rs.getInt(columnIndex++));
			product.setProductName(rs.getString(columnIndex++));
			product.setPrice(rs.getDouble(columnIndex++));
			brand.setBrandId(rs.getInt(columnIndex++));
			brand.setBrandName(rs.getString(columnIndex++));
		product.setBrand(brand);
		return product;
	}
	
	public List<Category> getCategoriesById(int categoryId) {
		final MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("category_id", categoryId);
		
		return namedJdbcTemplate.query(GET_CATEGORIES_QUERY, params, 
				(rs, rowNum) -> translateCategory(rs));
	}

	private Category translateCategory(ResultSet rs)  throws SQLException{
		int columnIndex = 1;
		Category category = new Category();
		category.setCategoryId(rs.getInt(columnIndex++));
		category.setCategoryName(rs.getString(columnIndex++));
		category.setParentId(rs.getInt(columnIndex++));
		return category;
	}
	
	public List<Brand> getBrandsByCategoryId(int categoryId) {
		final MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("category_id", categoryId);
		
		return namedJdbcTemplate.query(GET_BRANDS_QUERY, params, 
				(rs, rowNum) -> translateBrand(rs));
	}

	private Brand translateBrand(ResultSet rs) throws SQLException {
		int columnIndex = 1;
		Brand brand = new Brand();
		brand.setBrandId(rs.getInt(columnIndex++));
		brand.setBrandName(rs.getString(columnIndex++));
		return brand;
	}
	
	
}

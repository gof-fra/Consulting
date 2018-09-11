package com.haggar.consultingBackEnd.dao;

import java.util.List;

import com.haggar.consultingBackEnd.dto.Product;

public interface ProductDAO {
	
	List<Product> list();
	Product get(int productId);
	boolean add(Product product);
	boolean update(Product product);
	boolean delete(Product product);
	
	
	// method
	
	List<Product> listActiveProducts();
	List<Product> listActiveProductsByCategory(int categoryId);
	List<Product> getLatestActiveProducts(int count);
	
	
	
	

}

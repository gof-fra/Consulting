package com.haggar.consultingBackEnd.dao;

import java.util.List;

import com.haggar.consultingBackEnd.dto.Product;

public interface ProductDAO {
	
	Product get(int productId);
	List<Product> list();
	boolean add(Product product);
	boolean update(Product product);
	boolean delete(Product product);
	
	
	// methodes
	
	
	List<Product> listActiveProducts();
	List<Product> listActiveProductsByCategory(int categoryId);
	List<Product> getLatestActiveProducts(int count);
	
	

}

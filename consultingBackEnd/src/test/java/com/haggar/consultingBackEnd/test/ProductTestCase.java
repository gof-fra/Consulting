package com.haggar.consultingBackEnd.test;



import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.haggar.consultingBackEnd.dao.ProductDAO;
import com.haggar.consultingBackEnd.dto.Product;

public class ProductTestCase {
	
private static AnnotationConfigApplicationContext context;
	
	private static ProductDAO productDAO;
	
	private Product product;
	
	
	@BeforeClass
	public static void init() {
		
		context = new AnnotationConfigApplicationContext();
		context.scan("com.haggar.consultingBackEnd");
		context.refresh();
		
		productDAO = (ProductDAO)context.getBean("productDAO");
		
	}
	
	@Test
	public void testCRUDProduct() {
		
		// create operation
		
		product = new Product();
		
		product.setName("Oppo self 444");
		product.setBrand("Oppo");
		product.setDescription("This is a description for Oppo mobile!");
		product.setUnitPrice(25000);
		product.setActive(true);
		product.setCategoryId(3);
		product.setSupplierId(3);
		
	//	assertEquals("Something went wrong inserting a new product!", true, productDAO.add(product));
		assertEquals("dont", true, productDAO.add(product));
		
		
		product = productDAO.get(2);
		product.setName("Samsung Galaxy s7");
		
		assertEquals("Something went wrong updating a product!", true, productDAO.update(product));
		
		assertEquals("Something went wrong deleting a product!", true, productDAO.delete(product));
		
		
		// list
		
		assertEquals("Something went wrong while fetching(chercher) a product!", 5, productDAO.list().size()); //6 list of product + 1
		
		
	}
	
	
	/*@Test
	public void testActiveProduct() {
		assertEquals("Something went wrong while fetching(chercher) a product!", 3, productDAO.list().size()); //6 list of product + 1
		
		
	}*/
	
	

}

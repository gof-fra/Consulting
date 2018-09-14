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
	public static void unit() {
		
		context = new AnnotationConfigApplicationContext();
		context.scan("com.haggar.consultingBackEnd");
		context.refresh();
		productDAO = (ProductDAO) context.getBean("productDAO");
		
	}
	
	/*@Test
	public void testCRUDProduct () {
		
		// create operation
		
		product = new Product();
		
		product.setName("Oppo selfie 444");
		product.setBrand("Oppo");
		product.setDescription("Some description for Oppo");
		product.setUnitPrice(2300);
		product.setActive(true);
		product.setCategoryId(3);
		product.setSupplierId(3);
		
		
		assertEquals("Comment", true, productDAO.add(product));
		
		
		// reading and updating 
		
		product = productDAO.get(2);
		
		product.setName("Samsung galaxy s9");
		
		assertEquals("Comment", true, productDAO.update(product));
		
		
		assertEquals("Comment", true, productDAO.delete(product));
		
		// list
		
		assertEquals("Comment", 8, productDAO.list().size());
		

	}*/
	
	@Test
	public void testListActiveProducts () {
		
		assertEquals("Something went wrong while fetching the list of product", 7, productDAO.listActiveProducts().size());
		
	}
	
	@Test
	public void testListActiveProductsByCategory () {
		
		assertEquals("Something went wrong while fetching the list of product", 5, productDAO.listActiveProductsByCategory(3).size());
		
		assertEquals("Something went wrong while fetching the list of product", 2, productDAO.listActiveProductsByCategory(1).size());
		
	}
	
	@Test
	public void testGetlatestActiveProduct () {
		
		assertEquals("Something went wrong while fetching the list of product", 3, productDAO.getLatestActiveProducts(3).size());
		
		
	}

}

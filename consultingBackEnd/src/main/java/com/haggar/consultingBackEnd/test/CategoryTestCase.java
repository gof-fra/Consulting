package com.haggar.consultingBackEnd.test;



import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.haggar.consultingBackEnd.dao.CategoryDAO;
import com.haggar.consultingBackEnd.dto.Category;

	public class CategoryTestCase {
	
	private static AnnotationConfigApplicationContext context;
	
	
	private static CategoryDAO categoryDAO;
	
	
	private Category  category;
	
	@BeforeClass
	public static void init() {
		
		context = new AnnotationConfigApplicationContext();
		context.scan("com.haggar.consultingBackEnd");
		context.refresh();
		
		
		categoryDAO = (CategoryDAO)context.getBean("categoryDAO");
		
	}
	
	
	
	@Test
	public void testAddCategory() {
		
		category = new Category();
		
		category.setName("Mobile");
		category.setDescription("This is same description for mobile");
		category.setImageURL("CAT_1.png");
		
		assertEquals("Successfully added a category on the table!", true, categoryDAO.add(category));
		
	}

}

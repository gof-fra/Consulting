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
	
	private Category category;
	
	
	@BeforeClass
	public static void init() {
		
		context = new AnnotationConfigApplicationContext();
		context.scan("com.haggar.consultingBackEnd");
		context.refresh();
		
		categoryDAO = (CategoryDAO)context.getBean("categoryDAO");
		
	}
	
	/*@Test
	public void testCaseCategory ( ) {
		
		category = new Category();
		
		
		category.setName("tele");
		category.setDescription("this is some description for tele");
		category.setImageURL("CAT_131.png");
		
		assertEquals("succes", true, categoryDAO.add(category));
		
	}*/
	
	/*@Test
	public void testGetCategory() {
		
		category = categoryDAO.get(3);
		
		assertEquals("succes", "Laptop", category.getName());
		
	}*/
	
	
	/*@Test
	public void testUpdateCategory() {
		
		category = categoryDAO.get(3);
		
		category.setName("TV");
		
		assertEquals("succes", true, categoryDAO.update(category));
		
	}*/
	
	
	/*@Test
	public void testUpdateCategory() {
		
		category = categoryDAO.get(3);
		
		category.setName("TV");
		
		assertEquals("succes", true, categoryDAO.update(category));
		
	}*/
	
	
	/*@Test
	public void testDeleteCategory() {
		
		category = categoryDAO.get(3);
		
		category.setName("TV");
		
		assertEquals("succes", true, categoryDAO.delete(category));
		
	}*/
	
	
	/*@Test
	public void testListCategory() {
		
		category = categoryDAO.get(3);
		
		category.setName("TV");
		
		assertEquals("succes", 3, categoryDAO.list().size());
		
	}*/
	
	
	@Test
	public void testCRUDCategory() {
		
		// operation
		
		category = new Category();
		
		
		category.setName("Laptop");
		category.setDescription("This is some description for laptop");
		category.setImageURL("CAT_1.png");
		
		assertEquals("Succes added inside the table", true, categoryDAO.add(category));
		
		
		
		
		category = new Category();
		
		
		category.setName("Television");
		category.setDescription("This is some description for television");
		category.setImageURL("CAT_2.png");
		
		assertEquals("Succes added inside the table", true, categoryDAO.add(category));
		
		
		// updating
		
		category = categoryDAO.get(2);
		
		category.setName("TV");
		
		assertEquals("Succes updating", true, categoryDAO.update(category));
		
		
		
		// deleting
		
		
		
		assertEquals("Succes deleting", true, categoryDAO.delete(category));
		
		
		
		// fetching
		
		
		assertEquals("Succes fetching", 2, categoryDAO.list().size());
		
		
		
		
	}


}

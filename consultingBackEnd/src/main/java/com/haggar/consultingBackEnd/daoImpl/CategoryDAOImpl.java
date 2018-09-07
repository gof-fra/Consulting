package com.haggar.consultingBackEnd.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.haggar.consultingBackEnd.dao.CategoryDAO;
import com.haggar.consultingBackEnd.dto.Category;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {
	
	private static List<Category> categories = new ArrayList<>();
	
	
	static {
		
		// first
		
		Category category = new Category();
		
		category.setId(1);
		category.setName("Mobile");
		category.setDescription("this is some description for mobile");
		category.setImageURL("CAT_1.png");
		
		categories.add(category);
		
		
		// second
		
		
		category = new Category();
		
		category.setId(2);
		category.setName("Television");
		category.setDescription("this is some description for televion");
		category.setImageURL("CAT_2.png");
		
		categories.add(category);
		
		
		// third
		
		category = new Category();
		
		category.setId(3);
		category.setName("Laptop");
		category.setDescription("this is some description for laptop");
		category.setImageURL("CAT_3.png");
		
		categories.add(category);
		
	}

	@Override
	public List<Category> list() {
		
	
		return categories;
	}

	@Override
	public Category get(int id) {
		for (Category category: categories) {
			if(category.getId() == id ) return category;
		}
		
		return null;
	}

}

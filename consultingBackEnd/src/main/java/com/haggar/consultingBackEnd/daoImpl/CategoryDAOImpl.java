package com.haggar.consultingBackEnd.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.haggar.consultingBackEnd.dao.CategoryDAO;
import com.haggar.consultingBackEnd.dto.Category;

@Repository("categoryDAO") // in pom.xml end
public class CategoryDAOImpl implements CategoryDAO {

	private static List<Category> categories = new ArrayList<>();
	
	static {
		
		Category category = new Category();
		
		// adding the first category
		
		category.setId(1);
		category.setName("Mobile");
		category.setDescription("This is same description for mobile");
		category.setImageURL("CAT_1.png");
		
		categories.add(category);
		
		// adding the second category
		category = new Category();
		
		category.setId(2);
		category.setName("Television");
		category.setDescription("This is same description for television");
		category.setImageURL("CAT_2.png");
		
		categories.add(category);
		
		// adding the third category
		category = new Category();
		
		category.setId(3);
		category.setName("Laptop");
		category.setDescription("This is same description for laptop");
		category.setImageURL("CAT_3.png");
		
		categories.add(category);
		
	}

	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		return categories;
	}

	@Override
	public Category get(int id) {
		// TODO Auto-generated method stub
		
		for(Category category : categories) {
			
			if(category.getId() == id )
				return category;
			
		}
		
		return null;
	}
	
	
	

}

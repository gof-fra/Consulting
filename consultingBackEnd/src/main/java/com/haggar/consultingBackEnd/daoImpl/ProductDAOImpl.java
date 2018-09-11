package com.haggar.consultingBackEnd.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.haggar.consultingBackEnd.dao.ProductDAO;
import com.haggar.consultingBackEnd.dto.Product;


@Repository("productDAO")
@Transactional(noRollbackFor = Exception.class)
public class ProductDAOImpl implements ProductDAO {
	
	
	
	@Autowired
	private SessionFactory sessionFactory; 
	
	
	// List
	
	
	@Override
	public List<Product> list() {
		
		return
				sessionFactory
					.getCurrentSession()
						.createQuery("FROM Product", Product.class)
							.getResultList();
		
		
	}
	
	
	
	// single

	@Override
	public Product get(int productId) {
		
		try {
			
			return sessionFactory
					.getCurrentSession()
						.get(Product.class, Integer.valueOf(productId));
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		return null;
	}
	
	
	// Insert
	

	@Override
	public boolean add(Product product) {
		
		try {
			
			sessionFactory
				.getCurrentSession()
					.persist(product);
			
			return true;
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		return false;
		
	}
	
	
	// update
	

	@Override
	public boolean update(Product product) {
		
		try {
			
			sessionFactory
			.getCurrentSession()
				.update(product);
		
		return true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	
	// delete
	

	@Override
	public boolean delete(Product product) {
		
		try {
			
			product.setActive(false);
			
			return this.update(product);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	

	@Override
	public List<Product> listActiveProducts() {
		String selectActiveProducts = "FROM Product WHERE active = :active";
		return sessionFactory
					.getCurrentSession()
						.createQuery(selectActiveProducts, Product.class)
							.setParameter("active", true)
								.getResultList();
		
	}

	@Override
	public List<Product> listActiveProductsByCategory(int categoryId) {
		String selectActiveProductsByCategory = "FROM Product WHERE active = :active AND categoryId = :categoryId";
		return sessionFactory
					.getCurrentSession()
						.createQuery(selectActiveProductsByCategory, Product.class)
							.setParameter("active", true)
								.setParameter("categoryId", categoryId)
									.getResultList();
		
	}

	@Override
	public List<Product> getLatestActiveProducts(int count) {
		return sessionFactory
				.getCurrentSession()
					.createQuery("FROM Product WHERE active = :active ORDER BY id", Product.class)
						.setParameter("active", true)
							.setFirstResult(0)
								.setMaxResults(count)
									.getResultList();
	}

}

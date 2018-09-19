package com.haggar.consultingFrontEnd.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.haggar.consultingBackEnd.dao.CategoryDAO;
import com.haggar.consultingBackEnd.dao.ProductDAO;
import com.haggar.consultingBackEnd.dto.Category;
import com.haggar.consultingBackEnd.dto.Product;
import com.haggar.consultingFrontEnd.exception.ProductNotFoundException;

@Controller
public class PageController {
	
	private static final Logger logger = LoggerFactory.getLogger(PageController.class);
	
	@Autowired
	private CategoryDAO categoryDAO; 
	
	
	@Autowired
	private ProductDAO productDAO;
	
	
	@RequestMapping( value = {"/", "/home", "/index"})
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Home");
		
		//logger
		
		logger.info("Inside PageController index method - INFO");
		logger.debug("Inside PageController index method - DEBUG");
		
		// passing the first category
		
		mv.addObject("categories", categoryDAO.list());
		
		mv.addObject("userClickHome", true);
		
		
		return mv;
	}
	
	
	@RequestMapping( value = {"/about"})
	public ModelAndView about() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "About Us");
		mv.addObject("userClickAbout", true);
		
		
		return mv;
	}
	
	@RequestMapping( value = {"/contact"})
	public ModelAndView contact() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Contact Us");
		mv.addObject("userClickContact", true);
		
		
		return mv;
	}
	
	/*
	 * Methode to load all the products and based on category
	 * */
	
	@RequestMapping( value = "/show/all/products")
	public ModelAndView showAllProducts() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "All Products");
		
		// passing the list of category
		
		mv.addObject("categories", categoryDAO.list());
		
		mv.addObject("userClickAllProducts", true);
		
		
		return mv;
	}
	
	
	@RequestMapping( value = "/show/category/{id}/products")
	public ModelAndView showCategoryProducts(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView("page");
		
		// category for a single product
		Category category = null;
		
		category = categoryDAO.get(id);
		
		mv.addObject("title", category.getName());
		
		// passing the list of categories
		
		mv.addObject("categories", categoryDAO.list());
		
		// single category object
		
		mv.addObject("category", category);
		
		
		mv.addObject("userClickCategoryProducts", true);
		
		
		return mv;
	}
	
	
	// view a single product
	
	@RequestMapping(value = "/show/{id}/product")     // throws ProductNotFoundException(globaldefaultException)
	public ModelAndView showSingleProduct(@PathVariable int id) throws ProductNotFoundException {
		
		ModelAndView mv = new ModelAndView("page");
		
		Product product = productDAO.get(id);
		
		if(product == null) throw new ProductNotFoundException();
		
		// update the view count
		
		product.setViews(product.getViews() + 1);
		productDAO.update(product);
		
		
		//-------
		
		mv.addObject("title", product.getName());
		mv.addObject("product", product);
		
		mv.addObject("userClickShowProduct", true);
		
		return mv;
		
	}
	
	
	
	
	
	
	
	
	
	

}

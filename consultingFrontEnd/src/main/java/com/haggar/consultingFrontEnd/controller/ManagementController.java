package com.haggar.consultingFrontEnd.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.haggar.consultingBackEnd.dao.CategoryDAO;
import com.haggar.consultingBackEnd.dao.ProductDAO;
import com.haggar.consultingBackEnd.dto.Category;
import com.haggar.consultingBackEnd.dto.Product;
import com.haggar.consultingFrontEnd.utility.FileUploadUtility;
import com.haggar.consultingFrontEnd.validator.ProductValidator;

@Controller
@RequestMapping("/manage")
public class ManagementController {
	
	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	
	private static final Logger logger = LoggerFactory.getLogger(ManagementController.class);
	
	// manage product
	@RequestMapping(value = "/products", method=RequestMethod.GET)
	public ModelAndView showManageProducts(@RequestParam(name="operation", required=false) String operation) {
		
		ModelAndView mv = new ModelAndView("page");
		
		
		mv.addObject("userClickManageProducts", true);
		mv.addObject("title", "Manage Products");
		
		Product nProduct = new Product();
		
		// set few of the fields
		
		nProduct.setSupplierId(1);
		nProduct.setActive(true);
		
		mv.addObject("product", nProduct);
		
		if(operation != null) {
		
			if(operation.equals("product")) {  // add product and category
				
				mv.addObject("message", "Product Submitted Successfully!");
				
			}
			else if(operation.equals("category")) {
				
				mv.addObject("message", "Category Submitted Successfully!");
				
			}
			
		}
		
		
		return mv;
		
	}
	
	// updating product
	@RequestMapping(value="/{id}/product", method=RequestMethod.GET)
	public ModelAndView showEditProducts(@PathVariable int id) {
		
		ModelAndView mv = new ModelAndView("page");
		
		
		mv.addObject("userClickManageProducts", true);
		mv.addObject("title", "Manage Products");
		
		// fetch product in database
		Product nProduct = productDAO.get(id);
		// set the product fetching from database
		mv.addObject("product", nProduct);
		return mv;
		
	}
	
	
	// handling product submission
	@RequestMapping(value = "/products", method=RequestMethod.POST) // product ->form
	public String handlerProductSubmission(@Valid @ModelAttribute("product")Product mProduct, BindingResult results, Model model,
			HttpServletRequest request) {
		
		// vaildation for new product 
		
		if(mProduct.getId() == 0) {
			
			new ProductValidator().validate(mProduct, results);
			
		}
		else {
			if(!mProduct.getFile().getOriginalFilename().equals("")) {
				
				new ProductValidator().validate(mProduct, results);
				
			}
		}
		
		// check if there are any errors
		
		if(results.hasErrors()) {
			
			model.addAttribute("userClickManageProducts", true);
			model.addAttribute("title", "Manage Products");
			model.addAttribute("message", "Validation failed for product submission!");
			
			return "page";
			
		}
		
		
		// logger
		
		logger.info(mProduct.toString());
		
		
		if(mProduct.getId() == 0) {
			// create a new product record if id is 0
				productDAO.add(mProduct);
		}
		else {
			// updating the product if id is not 0
				productDAO.update(mProduct);
		}
		// uploading file
		
		
		if(!mProduct.getFile().getOriginalFilename().equals("")) {
			
			FileUploadUtility.uploadFile(request, mProduct.getFile(), mProduct.getCode());
			
		}
		
		
		return "redirect:/manage/products?operation=product";
	}
	
	
	// activate product
	
	@RequestMapping(value = "/product/{id}/activation", method=RequestMethod.POST)
	@ResponseBody
	public String handleProductActivation(@PathVariable int id) {
		
		// going to fetch product from database
		
		Product product = productDAO.get(id);
		boolean isActive = product.isActive();
		
		// activating and deactivating based on the value of active field
		product.setActive(!product.isActive());
		
		// updating the product
		productDAO.update(product);
		
		return (isActive)? 
						 "You are successfully deactive the product with id " + product.getId() 
						 :  "You are successfully active the product with id " + product.getId();
	}
	
	// category submission
	@RequestMapping(value="/category", method=RequestMethod.POST)
	public String handleCategorySubmission(@ModelAttribute Category category) {
		
		// add new category
		categoryDAO.add(category);
		
		return "redirect:/manage/products?operation=category";
		
	}
	
	// returning categories for all the request mapping 
	@ModelAttribute("categories")
	public List<Category> getCategories() {
		
		return categoryDAO.list();
		
	}
	
	@ModelAttribute("category")
	public Category getCategory() {
		
		return new Category();
		
	}
	
}

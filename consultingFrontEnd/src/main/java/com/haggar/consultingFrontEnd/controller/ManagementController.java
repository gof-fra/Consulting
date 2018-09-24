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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
		
			if(operation.equals("product")) {
				
				mv.addObject("message", "Product Submitted Successfully!");
				
			}
		}
		
		
		return mv;
		
	}
	
	
	// handling product submission
	@RequestMapping(value = "/products", method=RequestMethod.POST) // product ->form
	public String handlerProductSubmission(@Valid @ModelAttribute("product")Product mProduct, BindingResult results, Model model,
			HttpServletRequest request) {
		
		// validator 
		
		new ProductValidator().validate(mProduct, results);
		
		
		// check if there are any errors
		
		if(results.hasErrors()) {
			
			model.addAttribute("userClickManageProducts", true);
			model.addAttribute("title", "Manage Products");
			model.addAttribute("message", "Validation failed for product submission!");
			
			return "page";
			
		}
		
		
		// logger
		
		logger.info(mProduct.toString());
		
		// create a new product record
		productDAO.add(mProduct);
		
		// uploading file
		
		
		if(!mProduct.getFile().getOriginalFilename().equals("")) {
			
			FileUploadUtility.uploadFile(request, mProduct.getFile(), mProduct.getCode());
			
		}
		
		
		return "redirect:/manage/products?operation=product";
	}
	
	
	
	// returning categories for all the request mapping 
	@ModelAttribute("categories")
	public List<Category> getCategories() {
		
		return categoryDAO.list();
		
	}

}

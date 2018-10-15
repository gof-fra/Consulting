package com.haggar.consultingFrontEnd.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.stereotype.Component;

import com.haggar.consultingBackEnd.dao.UserDAO;
import com.haggar.consultingBackEnd.dto.Address;
import com.haggar.consultingBackEnd.dto.Cart;
import com.haggar.consultingBackEnd.dto.User;
import com.haggar.consultingFrontEnd.model.RegisterModel;

@Component
public class RegisterHandler {
	
	@Autowired
	private UserDAO userDAO;
	
	public RegisterModel init() {
		
		
		return new RegisterModel();
	}
	
	public void addUser(RegisterModel registerModel, User user) {
		
		registerModel.setUser(user);
	}
	
	public void addBilling(RegisterModel registerModel, Address billing) {
		
		registerModel.setBilling(billing);
	}
	
	public String validatorUser(User user, MessageContext error) {
		
		String transitionValue = "success";
		
		// knowing if password confirmed
		
		if(!(user.getPassword().equals(user.getConfirmPassword()))) {
			
			error.addMessage(new MessageBuilder()
					.error()
						.source("confirmPassword")
							.defaultText("Not the same password!")
								.build());
			
			transitionValue = "failure"; 
		}
		
		// // knowing if email confirmed
		
		if(userDAO.getByEmail(user.getEmail())!=null) {
			
			error.addMessage(new MessageBuilder()
					.error()
						.source("email")
							.defaultText("This email is already exist!")
								.build());
			
			transitionValue = "failure"; 
			
		}
		
		
		return transitionValue;
	}
	
	
	public String saveAll(RegisterModel model) {
		
		String transitionvalue = "success";
		
		// fetch
		
		User user = model.getUser();
		
		if(user.getRole().equals("USER")) {
			
			Cart cart = new Cart();
			cart.setUser(user);
			user.setCart(cart);
		}
		
		// save the user
		
		userDAO.addUser(user);
		
		// get the address
		
		Address billing = model.getBilling();
		
		billing.setId(user.getId());
		billing.setBilling(true);
		
		// save the address
		
		userDAO.addAddress(billing);
		
		return transitionvalue;
	}

}

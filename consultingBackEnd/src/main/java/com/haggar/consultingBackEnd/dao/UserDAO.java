package com.haggar.consultingBackEnd.dao;

import java.util.List;

import com.haggar.consultingBackEnd.dto.Address;
import com.haggar.consultingBackEnd.dto.Cart;
import com.haggar.consultingBackEnd.dto.User;

public interface UserDAO {
	
	// add user
	boolean addUser(User user);
	
	// getting user
	User getByEmail(String email);
	
	// add address
	boolean addAddress(Address address);
	
	//alternative
	
	//Address getBillingAddress(int userId);
	//List<Address> ListShippingAddress(int userId);
	
	

	Address getBillingAddress(User user);
	List<Address> ListShippingAddress(User user);
	
	
	// add cart  ->1
	// update cart ->2
	boolean addCart(Cart cart);
	
	boolean updateCart(Cart cart);

}

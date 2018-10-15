package com.haggar.consultingBackEnd.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.haggar.consultingBackEnd.dao.UserDAO;
import com.haggar.consultingBackEnd.dto.Address;
import com.haggar.consultingBackEnd.dto.Cart;
import com.haggar.consultingBackEnd.dto.User;

public class UserTestCase {
	
	private static AnnotationConfigApplicationContext context;
	private static UserDAO userDAO;
	private User user = null;
	private Address address = null;
	private Cart cart = null;
	
	
	@BeforeClass
	public static void init() {
		
		context = new AnnotationConfigApplicationContext();
		context.scan("com.haggar.consultingBackEnd");
		context.refresh();
		
		
		userDAO = (UserDAO) context.getBean("userDAO");
		
	}
	
	/*@Test
	public void testAdd() {
		
		user = new User();
		user.setFirstName("edy");
		user.setLastName("haggar");
		user.setEmail("edyhaggar@mail.com");
		user.setContactNumber("12345667");
		user.setRole("USER");
		user.setPassword("98989");
		
		// add user
		
		assertEquals("Failed to add user!", true, userDAO.addUser(user));
		
		
		address = new Address();
		address.setAddressLineOne("Alnasr");
		address.setAddressLineTwo("Kram");
		address.setCity("Tunis");
		address.setState("Gov Tunis");
		address.setCountry("Tunisie");
		address.setCodePostal("2222222");
		address.setBilling(true);
		
		// link the user with address using user id
		
		address.setUserId(user.getId());
		
		// add address 
		
		assertEquals("failed to add address!", true, userDAO.addAddress(address));
		
		if(user.getRole().equals("USER"))  {
			
			// create a cart for this user
			
			cart = new Cart();
			cart.setUser(user);
			
			// add cart 
			
			assertEquals("Failed to add cart!", true, userDAO.addCart(cart));
			
			// add a shipping address for this user
			
			address = new Address();
			address.setAddressLineOne("Alnasr");
			address.setAddressLineTwo("Kram");
			address.setCity("Tunis");
			address.setState("Gov Tunis");
			address.setCountry("Tunisie");
			address.setCodePostal("2222222");
			// set shipping true
			address.setBilling(true);
			
			// link it with the user
			
			address.setUserId(user.getId());
			
			// add shipping address
			
			assertEquals("failed to add shipping address!", true, userDAO.addAddress(address));

		}
	}
*/
	
	/*@Test
	public void testAdd() {
		
		user = new User();
		user.setFirstName("edy");
		user.setLastName("haggar");
		user.setEmail("edyhaggar@mail.com");
		user.setContactNumber("12345667");
		user.setRole("USER");
		user.setPassword("98989");
		
		
		if(user.getRole().equals("USER"))  {
			
			// create a cart for this user
			
			cart = new Cart();
			
			cart.setUser(user);
			
			// attach cart with the user
			
			user.setCart(cart);
			
			
		}
		// add user
		
		assertEquals("Failed to add user!", true, userDAO.addUser(user));
				
	}*/
	
	/*@Test
	public void testUpdateCart() {
		
		// fetch the user by it email
		
		user = userDAO.getByEmail("edyhaggar@mail.com");
		
		// get the cart od the user
		
		cart = user.getCart();
		
		cart.setGrandTotal(6666);
		
		cart.setCartLines(2);
		
		assertEquals("Failed to update the cart!", true, userDAO.updateCart(cart));
		
	}*/
	
	/*@Test
	public void testAddAddress() {
		
		// add user
		
		user = new User();
		user.setFirstName("edy");
		user.setLastName("haggar");
		user.setEmail("edyhaggar@mail.com");
		user.setContactNumber("12345667");
		user.setRole("USER");
		user.setPassword("98989");
		
		
		assertEquals("Failed to add user!", true, userDAO.addUser(user));
		
		// add address
		
		address = new Address();
		address.setAddressLineOne("Alnasr");
		address.setAddressLineTwo("Kram");
		address.setCity("Tunis");
		address.setState("Gov Tunis");
		address.setCountry("Tunisie");
		address.setCodePostal("2222222");
		address.setBilling(true);
		
		// attache the user to the address
		
		address.setUser(user);
		
		assertEquals("Failed to add address!", true, userDAO.addAddress(address));
		
		
		// add shipping address
		address = new Address();
		address.setAddressLineOne("Alnasr");
		address.setAddressLineTwo("Kram");
		address.setCity("Tunis");
		address.setState("Gov Tunis");
		address.setCountry("Tunisie");
		address.setCodePostal("2222222");
		// set shipping true
		address.setBilling(true);
		
		address.setUser(user);
		
		assertEquals("Failed to add the shipping address!", true, userDAO.addAddress(address));
		
		
	}*/
	
/*	@Test
	public void testAddress() {
		
		// add user
		
				user = new User();
				user.setFirstName("edy");
				user.setLastName("haggar");
				user.setEmail("edyhaggar@mail.com");
				user.setContactNumber("12345667");
				user.setRole("USER");
				user.setPassword("98989");
				
				
				assertEquals("Failed to add user!", true, userDAO.addUser(user));
				
				// add address
				
				address = new Address();
				address.setAddressLineOne("Test Alnasr");
				address.setAddressLineTwo("Kram");
				address.setCity("Tunis");
				address.setState("Gov Tunis");
				address.setCountry("Tunisie");
				address.setCodePostal("2222222");
				address.setBilling(true);
				
				// attache the user to the address
				
				address.setUser(user);
				
				assertEquals("Failed to add address!", true, userDAO.addAddress(address));
				
				
				// add shipping address
				address = new Address();
				address.setAddressLineOne("Alnasr");
				address.setAddressLineTwo("Kram");
				address.setCity("Tunis");
				address.setState("Gov Tunis");
				address.setCountry("Tunisie");
				address.setCodePostal("2222222");
				// set shipping true
				address.setBilling(true);
				
				address.setUser(user);
				
				assertEquals("Failed to add the shipping address!", true, userDAO.addAddress(address));

		
	}*/
	
	@Test
	public void testGetAddress() {
		
		user = userDAO.getByEmail("ed@mail.com");
		
		
		assertEquals("Failed to fetch the list of address and size does match!", 0, 
				userDAO.ListShippingAddress(user).size());
		
		assertEquals("Failed to fetch the list of address and size does match!", "Sousse", 
				userDAO.getBillingAddress(user).getCity());
		
		
	
		
		
	}
	/*@Test
	public void addCart() {
		
		cart = new Cart();
		cart.setUser(user);
		
		// add cart 
		
		assertEquals("Failed to add cart!", true, userDAO.addCart(cart));
		
	}
	*/
	

}








package com.niit.booksback;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.booksback.dao.CartDAO;
import com.niit.booksback.model.Cartitems;
import com.niit.booksback.model.Category;


public class CartTestCase {
	  static CartDAO cartDAO;
	  @BeforeClass
	  public static void initialize()
	  {
			AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext("com");
			cartDAO = (CartDAO)context.getBean("cartDAO");
	  }

	@Test
	public void addCart() {
		Cartitems cart=new Cartitems();
		 cart.setOrderid(1);
		 cart.setPrice(500);
		 cart.setProductid(1);
		 cart.setProductname("HungerBooks");
		 cart.setQunatity(2);
		 cart.setStatus("p");
		 cart.setUsername("user1");
		 assertEquals("New cart cannot be created",true,cartDAO.addCartItem(cart));
		 
	}

	@Test
	public void listCartitemsTest()
	{
		List<Cartitems>listCart=cartDAO.listCartItems("user1");
		assertTrue("Problem in listing categories from database",listCart.size()>0);
		for(Cartitems cart:listCart)
		{
			System.out.println(cart.getProductname()+" ");
			System.out.println(cart.getUsername()+" ");
			System.out.println(cart.getStatus());
		}
	}
}

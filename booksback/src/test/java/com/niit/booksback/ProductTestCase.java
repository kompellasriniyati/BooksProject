package com.niit.booksback;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.booksback.dao.CategoryDAO;
import com.niit.booksback.dao.ProductDAO;
import com.niit.booksback.model.Category;
import com.niit.booksback.model.Product;


public class ProductTestCase {

	static ProductDAO productDAO;
	static CategoryDAO categoryDAO;
	@BeforeClass
	   public static void initialize()
	   {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext("com");
		
		productDAO=(ProductDAO) context.getBean("productDAO");
		categoryDAO=(CategoryDAO)context.getBean("categoryDAO");
	   }

	@Test
	public void addProduct() {
		Product product=new Product();
		 product.setProductname("Trilogy");
		 product.setProductdescription("Books");
		 product.setPrice(700);
		 product.setStock(30);
		 Category category=categoryDAO.getCategory(3);
		 product.setCategory(category);
		 assertTrue("Problem in adding Product to Database",productDAO.addProduct(product));
	}
	

}




package com.niit.booksback;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.booksback.dao.SaveForLaterDAO;
import com.niit.booksback.model.SaveForLater;


public class SaveForTestCase {

	static SaveForLaterDAO saveForLaterDAO;
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext ("com");
		saveForLaterDAO =(SaveForLaterDAO)context.getBean("saveForLaterDAO");
		
	}
	@Test
	public void addItem()
	
	
	{
		SaveForLater savefor=new SaveForLater();
		savefor.setProductId(1);
		savefor.setProductName("saree");
		savefor.setPrice(1000);
		savefor.setUsername("user2");
		assertTrue("Item is not saved",saveForLaterDAO.addSavedItem(savefor));
		
		
		
		
	}

}

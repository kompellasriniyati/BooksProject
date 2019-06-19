package com.niit.booksback;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.booksback.dao.UserDAO;
import com.niit.booksback.model.User;

public class UserTestCase {
     
	static UserDAO userDAO;
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext("com");
		userDAO = (UserDAO)context.getBean("userDAO");
	}

@Test
public void registerUserTest()
{
	User userdetail=new User();
	userdetail.setEmailid("user1@gmail.com");
	userdetail.setPassword("password");
	userdetail.setRole("User1");
	userdetail.setFirstname("sri");
	userdetail.setLastname("niyati");
	userdetail.setEnabled(true);
	assertTrue("Problem in Registering UserDetail in Database",userDAO.registerUser(userdetail));
}

	
}




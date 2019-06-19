package com.niit.booksback;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.booksback.config.Dbconfig;

public class UserTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ac=new AnnotationConfigApplicationContext(Dbconfig.class);
		
	}

}
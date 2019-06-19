package com.niit.booksback;



import static org.junit.Assert.*;



import java.util.List;



import org.junit.BeforeClass;

import org.junit.Ignore;

import org.junit.Test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;



import com.niit.booksback.dao.CategoryDAO;

import com.niit.booksback.model.Category;



public class CategoryTestCase {

	static CategoryDAO categoryDAO;

	@BeforeClass

	public static void initialize()

	{

		AnnotationConfigApplicationContext ac=new AnnotationConfigApplicationContext("com");//It is a type of application context unit to create app obj as a singleton objects.

		categoryDAO=(CategoryDAO)ac.getBean("categoryDAO");

	}

	@Ignore

	@Test

	public void addCategory()

	{

		Category category=new Category();

		category.setCategoryname("Books");

		category.setCategorydescription("Fiction");

		assertEquals("Category insertion failed", true,categoryDAO.insertCategory(category));

	}

	@Ignore

	@Test

	public void removeCategory()

	{

		Category category=categoryDAO.getCategory(1);

		assertEquals("category removal failed", true,categoryDAO.deleteCategory(category));

	}

	@Test

	public void updateCategory()

	{

		Category category=categoryDAO.getCategory(33);

		category.setCategoryname("Books");

		category.setCategorydescription("Educational");

		assertEquals("category updation failed", true,categoryDAO.updateCategory(category));

		

	}

	@Ignore

	@Test

	public void listCategoriesTest()

	{

		List<Category>listCategories=categoryDAO.getCategories();

		assertTrue("Problem in listing categories from database",listCategories.size()>0);

		for(Category category:listCategories)

		{

			System.out.println(category.getCategoryid()+" ");

			System.out.println(category.getCategoryname()+" ");

			System.out.println(category.getCategorydescription());

		}

	}



}
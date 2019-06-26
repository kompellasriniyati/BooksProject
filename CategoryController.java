package com.bookweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.booksback.dao.CategoryDAO;
import com.niit.booksback.model.Category;


@Controller
public class CategoryController {

	@Autowired
	CategoryDAO categoryDAO;
	
	@RequestMapping("/Category")
	public String showCategory(Model m)
	{
		 List<Category> listCategories=categoryDAO.getCategories();
		 m.addAttribute("categories",listCategories);
		 return "Category";
	}
	@RequestMapping(value="/addcategory",method=RequestMethod.POST)
	public String InsertCategory(@RequestParam("catName")String categoryName,@RequestParam("catDesc")String categoryDesc,Model m)
	{
		Category category = new Category();
		category.setCategoryname(categoryName);
		category.setCategorydescription(categoryDesc);
		
		categoryDAO.insertCategory(category);
		
		List<Category> listCategories=categoryDAO.getCategories();
		m.addAttribute("categories",listCategories);
		return "Category";
	}
	
	@RequestMapping(value="/deleteCategory/{categoryId}")
	public String deleteCategory(@PathVariable("categoryId")int categoryId,Model m)
	{
		Category category= categoryDAO.getCategory(categoryId);
		
		categoryDAO.deleteCategory(category);
		List<Category>listCategories=categoryDAO.getCategories();
		m.addAttribute("categories",listCategories);
		return "Category";
	}
	
	@RequestMapping(value="/editCategory/{categoryid}")
	public String editCategory(@PathVariable("categoryid")int categoryId,Model m)
	{
		Category category= categoryDAO.getCategory(categoryId);
		m.addAttribute("editablecategory",category);
		
		return "UpdateCategory";
	}
	
	@RequestMapping(value="/UpdateCategory",method=RequestMethod.POST)
	public String updateCategory(@RequestParam("catId")int categoryId,@RequestParam("catName")String categoryName,@RequestParam("catDesc")String categoryDesc,Model m)
	{
		Category category= categoryDAO.getCategory(categoryId);
		category.setCategorydescription(categoryDesc);
		category.setCategoryname(categoryName);
		
		categoryDAO.updateCategory(category);
		
		List<Category>listCategories=categoryDAO.getCategories();
		m.addAttribute("categories",listCategories);
		return "Category";
	}
}


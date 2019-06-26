package com.bookweb.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.booksback.dao.CategoryDAO;
import com.niit.booksback.dao.SupplierDAO;
import com.niit.booksback.model.Category;
import com.niit.booksback.model.Supplier;



@Controller
public class SupplierController {
  
	@Autowired
	CategoryDAO categoryDAO;
	
	@Autowired
	SupplierDAO supplierDAO;
	
	@RequestMapping("/supplier")
	public String displaySupplier(Model m)
	{	

        Supplier supplier = new Supplier();
		m.addAttribute("supplier",supplier);
		
		List<Supplier> listSuppliers = supplierDAO.list();
		m.addAttribute("listSuppliers", listSuppliers);
		
		List<Category> listCategories = categoryDAO.getCategories();		
		m.addAttribute("listCategories",listCategories);

		return "Supplier";
	}
	
	@RequestMapping(value="/addsup",method=RequestMethod.POST)
	public String addSupplier(Model m,@ModelAttribute("supplier")Supplier supplier,BindingResult result, HttpServletRequest request)
	{
		supplierDAO.addSupplier(supplier);
		
        Supplier emptysupplier = new Supplier();
		m.addAttribute("supplier", emptysupplier);
		
		List<Supplier> listSuppliers = supplierDAO.list();
		m.addAttribute("listSuppliers", listSuppliers);
		
		List<Category> listCategories = categoryDAO.getCategories();	
		m.addAttribute("listCategories", listCategories);
		
		return "Supplier";
	}
	
	@RequestMapping(value="/deleteSupplier/{supplierId}")
	public String deleteSupplier(Model m,@PathVariable("supplierId")int supplierId)
	{
		Supplier supplier= supplierDAO.getSupplier(supplierId);
		supplierDAO.deleteSupplier(supplier);
		
		Supplier emptysupplier=new Supplier();
		m.addAttribute("supplier",emptysupplier);
		
		List<Supplier>listSuppliers=supplierDAO.list();
		m.addAttribute("suppliers",listSuppliers);
		
		return "Supplier";
	}
	
	@RequestMapping(value="/editSupplier/{supplierid}")
	public String editSupplier(@PathVariable("supplierid")int supplierId,Model m)
	{
		Supplier editablesupplier= supplierDAO.getSupplier(supplierId);
		m.addAttribute("editablesupplier",editablesupplier);
		
		List<Category> listCategories = categoryDAO.getCategories();	
		m.addAttribute("listCategories", listCategories);
		
		return "UpdateSupplier";
	}
	
	@RequestMapping(value="/UpdateSupplier",method=RequestMethod.POST)
	public String updateSupplier(Model m,@ModelAttribute("editablesupplier")Supplier editablesupplier)
	{
		supplierDAO.updateSupplier(editablesupplier);
		
		Supplier emptysupplierobj= new Supplier();
		m.addAttribute("supplier",emptysupplierobj);
		
		List<Supplier>listsuppliers=supplierDAO.list();
		m.addAttribute("categories",listsuppliers);
		
		List<Category> listCategories = categoryDAO.getCategories();	
		m.addAttribute("listCategories", listCategories);
		
		return "Supplier";
	}
}



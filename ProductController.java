package com.bookweb.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.niit.booksback.dao.CategoryDAO;
import com.niit.booksback.dao.ProductDAO;
import com.niit.booksback.model.Category;
import com.niit.booksback.model.Product;

@Controller
public class ProductController {

	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	CategoryDAO categoryDAO;
	HttpSession ses;
	@RequestMapping("/product")
	public String displayProduct(Model m)
	{
		Product product=new Product();
		m.addAttribute("product",product);
		
		List<Product> listProducts=productDAO.listProduct();
		m.addAttribute("listProducts",listProducts);
		
		List<Category> listCategories=categoryDAO.getCategories();
		m.addAttribute("listCategories",listCategories);
		
		return "Product";
	}
	
	@RequestMapping(value="/InsertProduct",method=RequestMethod.POST)
	public String addProduct(Model m,@ModelAttribute("product")Product product,@RequestParam("prodimage")MultipartFile image)
	{
		productDAO.addProduct(product);
		
		int ProductId=product.getProductid();
		String path="F:\\bookweb\\booksweb\\src\\main\\webapp\\resources\\images\\";
		
		path=path+String.valueOf(ProductId)+".jpg";
		System.out.println(path);
		
		File myImageFile=new File(path);
		
		if(!image.isEmpty())
		{
			try
			{
				byte buff[]=image.getBytes();
				FileOutputStream fos=new FileOutputStream(myImageFile);
				BufferedOutputStream bos=new BufferedOutputStream(fos);
				bos.write(buff);
				
				bos.close();
			}
			catch(Exception e)
			{
				m.addAttribute("Error","Error Occured during Image Uploading::"+e.getMessage());
			}
		}
			else
			{
				System.out.println("Error Occured While Uploading File");
				m.addAttribute("Error","Error Occured during Image Uploading");
			}
		 Product emptyProductobj=new Product();
		 m.addAttribute("Error", "Error Occured during Image Uploading");
		 
		 List<Category> listCategories=categoryDAO.getCategories();
		 m.addAttribute("listCategories",listCategories);
		 
		 List<Product> listProducts=productDAO.listProduct();
		 m.addAttribute("listProducts",listProducts);
		 
		 return "Product";
		}
	@RequestMapping(value="/deleteProduct/{productid}")
	public String deleteProduct(Model m,@PathVariable("productid")int productId)
	{
		Product product=productDAO.getProduct(productId);
		productDAO.deleteProduct(product);
		
		Product emptyProductobj=new Product();
		m.addAttribute("product",emptyProductobj);
		
		List<Product> listProducts=productDAO.listProduct();
		m.addAttribute("listProducts", listProducts);
		
		 List<Category> listCategories=categoryDAO.getCategories();
		 m.addAttribute("listCategories",listCategories);
		return "Product";
		
	}
	
	@RequestMapping(value="/editProduct/{productid}")
	public String editProduct(Model m,@PathVariable("productid")int productId)
	{
		Product editableproduct=productDAO.getProduct(productId);
		System.out.println(editableproduct.getProductid());
		m.addAttribute("editableproduct",editableproduct);
			
		
		 List<Category> listCategories=categoryDAO.getCategories();
		 m.addAttribute("listCategories",listCategories);
		 System.out.println("In Edit Product");
		return "UpdateProduct";
		
	}
	
	@RequestMapping(value="/UpdateProduct",method=RequestMethod.POST)
	public String updateProduct(Model m,@PathVariable("editableProduct")Product editableProduct)
	{
		System.out.println("In Update Product");
		productDAO.updateProduct(editableProduct);
		
		List<Product> listProducts=productDAO.listProduct();
		m.addAttribute("listProducts", listProducts);
		
		 List<Category> listCategories=categoryDAO.getCategories();
		 m.addAttribute("listCategories",listCategories);
		return "UpdateProduct";
		
	}
	
	@RequestMapping("/AllProducts")
	public String displayProducts(Model m,HttpServletRequest request)
	{
		 ses = request.getSession();
		List<Product> listProducts=productDAO.listProduct();
		m.addAttribute("listProducts", listProducts);
		
		String email=(String)ses.getAttribute("email");
		System.out.println("In All products page "+email);
		return "AllProducts";
	}
	

	@RequestMapping(value="/ProductDetails/{productid}")
	public String detailProductDisplay(@PathVariable("productid")int productid,Model m)
	{
	    Product product=productDAO.getProduct(productid);
	    m.addAttribute("product",product);
	    
	    String email=(String)ses.getAttribute("email");
		System.out.println("In All products page"+email);
	    return "ProductDetails";
	}
}



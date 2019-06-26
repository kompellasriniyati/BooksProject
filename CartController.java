package com.bookweb.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.booksback.dao.CartDAO;
import com.niit.booksback.dao.ProductDAO;
import com.niit.booksback.dao.SaveForLaterDAO;
import com.niit.booksback.model.Cartitems;
import com.niit.booksback.model.Product;
import com.niit.booksback.model.SaveForLater;

@Controller
public class CartController {

	@Autowired
	CartDAO cartDAO;
	
	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	SaveForLaterDAO saveForLaterDAO;
	
	@RequestMapping("/Cart")
	public String DisplayCart(Model m,HttpSession session)
	{
		String username=(String)session.getAttribute("email");
		
		List<Cartitems> listCartItems = cartDAO.listCartItems(username);
		m.addAttribute("listCartItems", listCartItems);
		m.addAttribute("cartsize", listCartItems.size());
		m.addAttribute("CartValue", CartValue(listCartItems));
		
		List<SaveForLater> savedItemsList = saveForLaterDAO.savedItemsList(username);
		m.addAttribute("count", savedItemsList.size());
		m.addAttribute("savedItemsList", savedItemsList);
		session.setAttribute("cartsize", listCartItems.size());
			
		return "CartDisplay";
	}
	
	//Add to Cart from Product Details Page
	
	@RequestMapping(value="/addToCart/{productid}")
	public String addToCart(Model m,@PathVariable("productid")int productID,HttpSession session)
	{
		String username=(String)session.getAttribute("email");
		System.out.println("In cart "+username);
		Product product =productDAO.getProduct(productID);
		
		Cartitems cartItem = new Cartitems();
		cartItem.setProductid(product.getProductid());
		cartItem.setProductname(product.getProductname());
		cartItem.setStatus("NotPresent");
		cartItem.setPrice(product.getPrice());
		cartItem.setQunatity(1);
		cartItem.setUsername(username);
		
		cartDAO.addCartItem(cartItem);
		
		List<Cartitems> listCartItems = cartDAO.listCartItems(username);
		m.addAttribute("listCartItems", listCartItems);
		/*m.addAttribute("cartsize", listCartItems.size());*/
		m.addAttribute("CartValue", CartValue(listCartItems));
		
		List<SaveForLater> savedItemsList = saveForLaterDAO.savedItemsList(username);
		System.out.println("In cart Save for Later");
		m.addAttribute("count", savedItemsList.size());
		m.addAttribute("savedItemsList", savedItemsList);
		session.setAttribute("cartsize", listCartItems.size());

		return "CartDisplay";
	}
	
	//Calculating Total Cart Value
	
	public int CartValue(List<Cartitems> listCartItems)
	{
		int total=0;
		for(Cartitems item:listCartItems)
		{
			total=total+(item.getQunatity()*item.getPrice());
		}
		return total;
	}

	
	@RequestMapping(value="/deleteCartItem/{cartitemid}")
	public String deleteCartItem(@PathVariable("cartitemid")int cartItemId,Model m,HttpSession session)
	{
		String username=(String)session.getAttribute("email");

		Cartitems cartItem = cartDAO.getCartItem(cartItemId);
		cartDAO.deleteCartItem(cartItem);
		
		List<Cartitems> listCartItems = cartDAO.listCartItems(username);
		m.addAttribute("listCartItems", listCartItems);
		m.addAttribute("cartsize", listCartItems.size());
		m.addAttribute("CartValue", CartValue(listCartItems));
		
		List<SaveForLater> savedItemsList = saveForLaterDAO.savedItemsList(username);
		m.addAttribute("count", savedItemsList.size());
		m.addAttribute("savedItemsList", savedItemsList);
		session.setAttribute("cartsize", listCartItems.size());

		
		return "CartDisplay";
 
	}
	
	
	@RequestMapping(value="/updateCartItem/{cartitemid}")
	public String updateCartItem(@PathVariable("cartitemid")int cartItemId,Model m,@RequestParam("quantity")int quantity,HttpSession session)
	{
		String username=(String)session.getAttribute("email");

		Cartitems cartItem = cartDAO.getCartItem(cartItemId);
		cartItem.setUsername(username);
		cartItem.setQunatity(quantity);
		cartDAO.updateCartItem(cartItem);
		
		List<Cartitems> listCartItems = cartDAO.listCartItems(username);
		m.addAttribute("listCartItems", listCartItems);
		m.addAttribute("cartsize", listCartItems.size());
		m.addAttribute("CartValue",CartValue(listCartItems));
		
		List<SaveForLater> savedItemsList = saveForLaterDAO.savedItemsList(username);
		m.addAttribute("count", savedItemsList.size());
		m.addAttribute("savedItemsList", savedItemsList);
		session.setAttribute("cartsize", listCartItems.size());

		return "CartDisplay";
 

	}
	
}

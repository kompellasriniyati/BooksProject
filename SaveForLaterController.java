package com.bookweb.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.booksback.dao.CartDAO;
import com.niit.booksback.dao.ProductDAO;
import com.niit.booksback.dao.SaveForLaterDAO;
import com.niit.booksback.model.Cartitems;
import com.niit.booksback.model.Product;
import com.niit.booksback.model.SaveForLater;

@Controller
public class SaveForLaterController {
	@Autowired
	CartDAO cartDAO;
	
	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	SaveForLaterDAO saveForLaterDAO;
	
	//Save for Later from All Products Page
	
	@RequestMapping("/saveForLater/{productId}")
	public String addToSaveForLater(@PathVariable("productId")int productId,Model m,HttpSession session)
	{
		String username=(String)session.getAttribute("email");

		Product product = productDAO.getProduct(productId);

		SaveForLater savedItem = new SaveForLater();
		savedItem.setProductId(productId);
		savedItem.setProductName(product.getProductname());
		savedItem.setPrice(product.getPrice());
		savedItem.setUsername(username);
		System.out.println("save for later "+username);
		saveForLaterDAO.addSavedItem(savedItem);
				
		List<Cartitems> listCartItems = cartDAO.listCartItems(username);
		m.addAttribute("listCartItems", listCartItems);
		m.addAttribute("cartsize", listCartItems.size());
		m.addAttribute("CartValue", this.CartValue(listCartItems));
				
		List<SaveForLater> savedItemsList = saveForLaterDAO.savedItemsList(username);
		m.addAttribute("count", savedItemsList.size());
		m.addAttribute("savedItemsList", savedItemsList);
		session.setAttribute("cartsize", listCartItems.size());

		return "CartDisplay";		
	}
	
	//Save for Later from Cart Table 
	
		@RequestMapping("/moveTosaveForLater/{cartItemId}")
		public String moveToSaveForLater(@PathVariable("cartItemId")int cartItemId,Model m,HttpSession session)
		{
			String username=(String)session.getAttribute("email");
			
			Cartitems cartItem = cartDAO.getCartItem(cartItemId);

			Product product = productDAO.getProduct(cartItem.getProductid());

			SaveForLater savedItem = new SaveForLater();
			savedItem.setProductId(product.getProductid());
			savedItem.setProductName(product.getProductname());
			savedItem.setPrice(product.getPrice());
			savedItem.setUsername(username);
			
			saveForLaterDAO.addSavedItem(savedItem);
			
			cartDAO.deleteCartItem(cartItem);
			
			List<Cartitems> listCartItems = cartDAO.listCartItems(username);
			m.addAttribute("listCartItems", listCartItems);
			m.addAttribute("cartsize", listCartItems.size());
			m.addAttribute("CartValue", this.CartValue(listCartItems));
					
			List<SaveForLater> savedItemsList = saveForLaterDAO.savedItemsList(username);
			m.addAttribute("count", savedItemsList.size());
			m.addAttribute("savedItemsList", savedItemsList);
			session.setAttribute("cartsize", listCartItems.size());

			return "CartDisplay";		
		}

	//Move to Cart from Saved Items List
	
			@RequestMapping(value="/moveToCart/{savedItemId}")
			public String moveToCart(Model m,@PathVariable("savedItemId")int savedItemId,HttpSession session)
			{
				String username=(String)session.getAttribute("email");
				
				SaveForLater savedItem =saveForLaterDAO.getSavedItems(savedItemId);
				
				Product product = productDAO.getProduct(savedItem.getProductId());
				
				if(product.getStock()>0)
				{
				Cartitems cartItem = new Cartitems();
				cartItem.setProductid(product.getProductid());
				cartItem.setProductname(product.getProductname());
				cartItem.setStatus("NotPresent");
				cartItem.setPrice(product.getPrice());
				cartItem.setQunatity(1);
				cartItem.setUsername(username);
				
				cartDAO.addCartItem(cartItem);
				
				saveForLaterDAO.deleteSavedItem(savedItem);

				}
				
				List<Cartitems> listCartItems = cartDAO.listCartItems(username);
				m.addAttribute("listCartItems", listCartItems);
				m.addAttribute("cartsize", listCartItems.size());
				m.addAttribute("CartValue", this.CartValue(listCartItems));
				
				
				List<SaveForLater> savedItemsList = saveForLaterDAO.savedItemsList(username);
				m.addAttribute("count", savedItemsList.size());
				m.addAttribute("savedItemsList", savedItemsList);
				session.setAttribute("cartsize", listCartItems.size());

				return "CartDisplay";
			}
		
			
		//Delete from Saved for later list
			
		@RequestMapping(value="/deletesaveditem/{savedItemId}")
		public String deleteSavedItem(@PathVariable("savedItemId")int savedItemId,Model m,HttpSession session)
		{
			String username=(String)session.getAttribute("email");

			SaveForLater savedItem=saveForLaterDAO.getSavedItems(savedItemId);
			saveForLaterDAO.deleteSavedItem(savedItem);
			
			List<Cartitems> listCartItems = cartDAO.listCartItems(username);
			m.addAttribute("listCartItems", listCartItems);
			m.addAttribute("cartsize", listCartItems.size());
			m.addAttribute("CartValue", this.CartValue(listCartItems));
			
			List<SaveForLater> savedItemsList = saveForLaterDAO.savedItemsList(username);
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


}

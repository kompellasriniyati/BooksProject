package com.bookweb.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.booksback.dao.CartDAO;
import com.niit.booksback.dao.OrderdetailsDAO;
import com.niit.booksback.dao.UserDAO;
import com.niit.booksback.model.Cartitems;
import com.niit.booksback.model.OrderDetails;
import com.niit.booksback.model.User;

@Controller
public class OrderController {
	@Autowired
	CartDAO cartDAO;
	
	@Autowired
	OrderdetailsDAO orderDetailDAO; 
	
	@Autowired
	UserDAO userDAO;
	
		
	@RequestMapping("/checkout")
	public String checkout(Model m,HttpSession session)
	{
		String username=(String)session.getAttribute("email");

		List<Cartitems> listCartItems = cartDAO.listCartItems(username);
	    m.addAttribute("listCartItems", listCartItems);
	    m.addAttribute("CartValue", CartValue(listCartItems));
		session.setAttribute("cartsize", listCartItems.size());

		return "CheckoutPage";
	}
	
	@RequestMapping(value="/confirmAddress",method=RequestMethod.POST)
	public String confirmAddress(HttpSession session,Model m,@RequestParam("Name")String Name,@RequestParam("Number")String Number,@RequestParam("PinCode")String PinCode,@RequestParam("HouseAddress")String HouseAddress,@RequestParam("City")String City,@RequestParam("State")String State)
	{
		String username=(String)session.getAttribute("username");

		String Address = Name+" ,"+HouseAddress+" ,"+Number+" ,"+City+" ,"+State+" ,"+PinCode;
		
		User user = userDAO.getUser(username);
		//user.setAddress(Address);
		userDAO.updateUser(user);
		
		List<Cartitems> listCartItems = cartDAO.listCartItems(username);
	    m.addAttribute("CartValue", CartValue(listCartItems));
	    
		return "PaymentPage";
	}

	@RequestMapping(value="/confirmPayment",method=RequestMethod.POST)
	public String confirmPayment(Model m,@RequestParam("paymentMode")String paymentMode,HttpSession session)
	{
		String username=(String)session.getAttribute("username");

		List<Cartitems> listCartItems = cartDAO.listCartItems(username);
	    int Order_Total =  CartValue(listCartItems);
	    
		OrderDetails newOrder = new OrderDetails();
		newOrder.setPaymentmode(paymentMode);
		newOrder.setUsername(username);
		newOrder.setOrderdate(new java.util.Date());
		orderDetailDAO.paymentProcess(newOrder);
		
		orderDetailDAO.updateCartItemStatus(username, newOrder.getOrderid());
		
		User user = userDAO.getUser(username);
		
	
		
	    m.addAttribute("listCartItems", listCartItems);
	 
	    m.addAttribute("CartValue", CartValue(listCartItems));
	    
	    m.addAttribute("orderId", newOrder.getOrderid());
	    m.addAttribute("orderDate", newOrder.getOrderdate());
	    m.addAttribute("orderPayment", newOrder.getPaymentmode());
	      
	    
	    // delete items in Cart after Receipt is done
		List<Cartitems> listCartItems2 = cartDAO.listCartItems(username);
	    for(Cartitems cartItem:listCartItems2)
	    {
	    	cartDAO.deleteCartItem(cartItem);
	    }
	    
	    session.setAttribute("cartsize",0);
	    return "Receipt";
	}
	

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

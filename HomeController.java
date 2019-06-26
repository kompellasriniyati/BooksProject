package com.bookweb.controller;

import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.booksback.dao.ProductDAO;
import com.niit.booksback.dao.UserDAO;
import com.niit.booksback.model.User;

@Controller
public class HomeController {
	@Autowired
	UserDAO userDAO;
	ProductDAO productDAO;
	@Autowired
	private JavaMailSender mailSender;
	@RequestMapping("/")
	public String showHome()
	{
		return "home";
	}
	@RequestMapping("/register")
	public String showRegister(Model model)
	{
		model.addAttribute("user",new User());
		return "Registration";
	}
	@RequestMapping("/Login")
	public String showLogin(Model m)
	{
		return "Login";
		/*m.addAttribute("product",new Product());
		return "redirect:/product";*/
		/*m.addAttribute("supplier",new Supplier());
		return "redirect:/supplier";*/
	}
	 
	@RequestMapping(value="/adduser",method=RequestMethod.POST)
	public String adduser(@ModelAttribute("user")User user,BindingResult result,HttpServletRequest request)
	{
		String email=user.getEmailid();
		HttpSession session=request.getSession();
		session.setAttribute("email", email);
		System.out.println("Here");
		System.out.println(user.getPassword());
		user.setRole("ROLE_USER");
		user.setEnabled(true);
		String email1=(String)session.getAttribute("email");
		String recipient=email1;
		String subject="userregistration";
		String message="user registered succesfully\n"+ "The Deatils are "+"\n UserName:"+user.getFirstname()+"\n Email id:"+user.getEmailid();
		userDAO.registerUser(user);
		System.out.println(message);
		SimpleMailMessage simplemail=new SimpleMailMessage();
		simplemail.setTo(recipient);
		simplemail.setSubject(subject);
        simplemail.setText(message);	
        simplemail.setBcc("kompellasriniyathi@gmail.com");
        mailSender.send(simplemail);
        
		return "Login";	
	}
	
@RequestMapping(value = "/login_success")
	public String loginCheck(Model m, HttpSession session) {
		System.out.println("In Security");
		String page = "";
		boolean loggedIn = false;
		User user=new User();
		SecurityContext securityContext = SecurityContextHolder.getContext();
		Authentication authentication = securityContext.getAuthentication();

		String username = authentication.getName();
		System.out.println(username);
		
		//session.setAttribute("email", user.getEmailid());
		session.setAttribute("LoggedInUser", username);
		session.setAttribute("LoggedIn", "true");
		
		
		Collection<GrantedAuthority> roles = (Collection<GrantedAuthority>) authentication.getAuthorities();

		for (GrantedAuthority role : roles) {
			session.setAttribute("role", role.getAuthority());

			if (role.getAuthority().equals("ROLE_ADMIN")) {
				loggedIn = true;
				page = "AdminHome";
				session.setAttribute("loggedIn", loggedIn);
				session.setAttribute("username", username);
			} else {
				m.addAttribute("pageinfo", "UserHome");

				//List<Product> listProducts = productDAO.listProduct();
				//m.addAttribute("productList", listProducts);

				loggedIn = true;
				page = "UserHome";
				session.setAttribute("loggedIn", loggedIn);
				session.setAttribute("username", username);

				//List<Cart> listCartItems = cartDAO.listCartItems(username);
			//	session.setAttribute("cartsize", listCartItems.size());

			}
		}
		return page;
	}


}


package com.niit.booksback.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.booksback.model.Cartitems;
@Repository("cartDAO")
@Transactional

public class CartDAOImpl implements CartDAO {
	@Autowired
	SessionFactory sessionFactory;

	public boolean addCartItem(Cartitems cartItem) {
		try 
		{
			Session session=sessionFactory.getCurrentSession();
			session.save(cartItem);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
		
	}

	public boolean deleteCartItem(Cartitems cartItem) {
		try 
		{
			Session session=sessionFactory.getCurrentSession();
			session.delete(cartItem);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	public boolean updateCartItem(Cartitems cartItem) {
		try 
		{
			Session session=sessionFactory.getCurrentSession();
			session.update(cartItem);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	public Cartitems getCartItem(int cartItemId) {
		try
		{
			Session session=sessionFactory.openSession();
			Cartitems cart=(Cartitems) session.get(Cartitems.class,cartItemId);
			session.close();
			return cart;
		}
		catch(Exception e)
		{
			return null;
		}
	}

	public List<Cartitems> listCartItems(String username) {
		try
		{
			Session session=sessionFactory.openSession();
			Query query=session.createQuery("From cart where username=:userName");
			query.setParameter("userName",username);
			List<Cartitems>listCartitems=(List<Cartitems>)query.list();
			return listCartitems;
		}
		catch(Exception e)
		{
			return null;
		}
	}

}
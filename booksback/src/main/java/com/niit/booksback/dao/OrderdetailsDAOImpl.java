package com.niit.booksback.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.booksback.model.OrderDetails;



@Repository("orderdetailDAO")
@Transactional
public class OrderdetailsDAOImpl implements OrderdetailsDAO {

	@Autowired
	SessionFactory sessionFactory;
	public boolean paymentProcess(OrderDetails order) {
		try
		{
			Session session=sessionFactory.getCurrentSession();
			session.save(order);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	public boolean updateCartItemStatus(String username, int orderId) {
		try
		{
			Session session=sessionFactory.getCurrentSession();
			Query query=session.createQuery("Update cart set status='P',OrderId=:orderId where UserName=:username and status='NP'");
			query.setParameter("UserName",username);
			query.setParameter("orderId", orderId);
			int roweffected=query.executeUpdate();
			
			if(roweffected>0)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
			return false;
		}
		
	}

}

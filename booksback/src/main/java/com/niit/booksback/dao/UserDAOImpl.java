package com.niit.booksback.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.booksback.model.User;
@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDAO {
	@Autowired
	SessionFactory sessionFactory;
	

	public boolean registerUser(User userdetail) {
		try
		{
			Session session=sessionFactory.getCurrentSession();
			session.save(userdetail);
			return true;
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean updateUser(User user) {
		try
		{
			Session session=sessionFactory.getCurrentSession();
			session.update(user);
			return true;
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return false;
		}
	}
	

	public User getUser(String email) {
		Session session=sessionFactory.openSession();
		User userdetail=session.get(User.class,email);
		session.close();
		return userdetail;
	}

}

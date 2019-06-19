package com.niit.booksback.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.booksback.model.Product;

@Repository("productDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO {
@Autowired
SessionFactory sessionFactory;

	public boolean addProduct(Product product) {
		try
		{
			Session session=sessionFactory.getCurrentSession();
			session.save(product);
			System.out.println("New category added");
			return true;
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			System.out.println("Not updated");
			return false;
		}
		
	}

	public boolean updateProduct(Product product) {
		try
		{
			Session session=sessionFactory.getCurrentSession();
			session.update(product);
			System.out.println("New category added");
			return true;
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			System.out.println("Not updated");
			return false;
		}
	}

	public boolean deleteProduct(Product product) {
		try
		{
			Session session=sessionFactory.getCurrentSession();
			session.delete(product);
			System.out.println("New category added");
			return true;
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			System.out.println("Not updated");
			return false;
		}
	}

	public Product getProduct(int productID) {
		Session session=sessionFactory.openSession();
		Product product=(Product)session.get(Product.class,productID);
		session.close();
		return product;
		
	}

	public List<Product> getProductByCategoryID(int categoryID) {
		
			Session session=sessionFactory.openSession();
			Query query=session.createQuery("From Product where Category_categoryId=:categoryID");
			query.setParameter("categoryId",categoryID);
			List<Product>list=(List<Product>)query.list();
			session.close();
			return list;
		}
		
	

	public List<Product> listProduct() {
		
		Session	session=sessionFactory.openSession();
		Query query=session.createQuery("From Product");
		List<Product>list=(List<Product>)query.list();
		session.close();
		return list;
			
		
	}

}

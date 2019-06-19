package com.niit.booksback.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.booksback.model.Supplier;

@Repository("supplierDAO")
@Transactional
public class SupplierDAOImpl implements SupplierDAO {
    @Autowired
    SessionFactory sessionFactory;
	public boolean addSupplier(Supplier supplier) {
		try
		{
			Session session=sessionFactory.getCurrentSession();
			session.save(supplier);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("New supplier cannot be saved");
			return false;
		}
		
	}

	public boolean deleteSupplier(Supplier supplier) {
		
		try
		{
			Session session=sessionFactory.getCurrentSession();
			session.delete(supplier);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("New supplier cannot be deleted");
			return false;
		}
	}

	public boolean updateSupplier(Supplier supplier) {
		try
		{
			Session session=sessionFactory.getCurrentSession();
			session.update(supplier);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("New supplier cannot be updated");
			return false;
		}
	}

	public Supplier getSupplier(int ID) {
		Session session=sessionFactory.openSession();
		Supplier supplier=(Supplier)session.get(Supplier.class, ID);
		session.close();
		return null;
	}

	public List<Supplier> list() {
		try
		{
			Session session=sessionFactory.openSession();
			Query query=session.createQuery("From Supplier");
			List<Supplier>list=(List<Supplier>)query.list();
			session.close();
			return list;
		}
		catch(Exception e)
		{
			System.out.println("cannot retrive supplier list");
			return null;
		}
	}

	public List<Supplier> listsupplierByCategoryID(int categoryid) {
		try
		{
			Session session=sessionFactory.openSession();
			Query query=session.createQuery("From Supplier where Category_categoryId=:categoryid");
			query.setParameter("categoryid",categoryid);
			List<Supplier>list=(List<Supplier>)query.list();
			session.close();
			return list;
		}
		catch(Exception e)
		{
			System.out.println("cannot retrive supplier based on category");
			return null;
		}
	}

}
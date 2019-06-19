package com.niit.booksback.dao;

import java.util.List;

import com.niit.booksback.model.Product;



public interface ProductDAO {

	public boolean addProduct(Product product);
	public boolean updateProduct(Product product);
	public boolean deleteProduct(Product product);
	public Product getProduct(int productID);
	public List<Product> getProductByCategoryID(int categoryID);
	public List<Product>listProduct();
}

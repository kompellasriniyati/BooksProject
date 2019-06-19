package com.niit.booksback.dao;

import com.niit.booksback.model.OrderDetails;

public interface OrderdetailsDAO {

	     public boolean paymentProcess(OrderDetails order);
	     public boolean updateCartItemStatus(String username,int orderId);
	}


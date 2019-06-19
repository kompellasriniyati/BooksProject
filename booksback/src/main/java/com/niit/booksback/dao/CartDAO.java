package com.niit.booksback.dao;

import java.util.List;

import com.niit.booksback.model.Cartitems;

public interface CartDAO {
       public boolean addCartItem(Cartitems cartItem);
       public boolean deleteCartItem(Cartitems cartItem );
       public boolean updateCartItem(Cartitems cartItem);
       public Cartitems getCartItem(int cartItemId);
       public List<Cartitems> listCartItems(String username);
}


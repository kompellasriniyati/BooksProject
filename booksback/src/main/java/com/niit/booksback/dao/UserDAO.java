package com.niit.booksback.dao;

import com.niit.booksback.model.User;

public interface UserDAO {
	public boolean registerUser(User user);
	public boolean updateUser(User user);
	public User getUser(String username);
}

package com.niit.booksback.dao;

import java.util.List;

import com.niit.booksback.model.SaveForLater;



public interface SaveForLaterDAO {

	public boolean addSavedItem(SaveForLater savedItem);
	public SaveForLater getSavedItems(int savedItemId);
	public boolean deleteSavedItem(SaveForLater savedItem);
	public List<SaveForLater>savedItemsList(String username);
}

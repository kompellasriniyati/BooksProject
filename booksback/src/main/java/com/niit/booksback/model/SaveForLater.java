package com.niit.booksback.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class SaveForLater {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
int savedItemId;
int price;
int productId;
String username;
String productName;
public int getSavedItemId() {
	return savedItemId;
}
public void setSavedItemId(int savedItemId) {
	this.savedItemId = savedItemId;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
public int getProductId() {
	return productId;
}
public void setProductId(int productId) {
	this.productId = productId;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getProductName() {
	return productName;
}
public void setProductName(String productName) {
	this.productName = productName;
}

}

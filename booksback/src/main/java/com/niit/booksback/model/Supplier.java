package com.niit.booksback.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table
public class Supplier {
	
	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
     private int supplierid;
	 @NotNull
     private String suppliername;
	@ManyToOne
	   @JoinColumn(referencedColumnName="categoryid")
	   private Category category;
     private String supplierdescription;
     
     public Category getCategory() {
 		return category;
 	}
 	public void setCategory(Category category) {
 		this.category = category;
 	}
     public int getSupplierid() {
	return supplierid;
}
public void setSupplierid(int supplierid) {
	this.supplierid = supplierid;
}
public String getSuppliername() {
	return suppliername;
}
public void setSuppliername(String suppliername) {
	this.suppliername = suppliername;
}
public String getSupplierdescription() {
	return supplierdescription;
}
public void setSupplierdescription(String supplierdescription) {
	this.supplierdescription = supplierdescription;
}

}

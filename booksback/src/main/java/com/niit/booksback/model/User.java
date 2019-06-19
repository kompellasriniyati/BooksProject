package com.niit.booksback.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
@Entity
@Table

public class User {
      @Id
      @GeneratedValue(strategy=GenerationType.IDENTITY)
     
      private int userid;	
      @Column(name="firstname")
      private String firstname;
      @NotNull
      @Column(name="lastname")
      private String lastname;
      @NotNull
      @Column(name="email",unique=true,length=100)
      private String emailid;
      @NotNull
      @Column(name="address")
      private String address;
      @NotNull
      @Column(name="location")
      private String location;
      @NotNull
      @Column(name="contactno")
      private String contactno;
      @NotNull
      private String password;
      private String role;
      private boolean enabled;
      public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
        
     
 
      public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getContactno() {
		return contactno;
	}
	public void setContactno(String contactno) {
		this.contactno = contactno;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmpassword() {
		return confirmpassword;
	}
	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Transient
	@NotNull
	private String confirmpassword;  
	 
	
}



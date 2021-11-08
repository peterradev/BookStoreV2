package com.ebook.model.partner;

import java.util.ArrayList;
import java.util.List;

import com.ebook.model.customer.Customer;
import com.ebook.model.item.Product;


public class Partner extends Customer{
	
	private String partnerID;
	private String lastName;
	private String firstName;

	
	public Partner() {}
	
	
	public String getPartnerID() {
		return partnerID;
	}

	public void setPartnerID(String partnerID) {
		this.partnerID = partnerID;
	}

	public void setLastName(String lname) {
		this.lastName = lname;
	}

	public String getLastName() {
		return this.lastName;
	}


	public void setFirstName(String fname) {
		this.firstName = fname;
	}
	
	public String getFirstName() {
		return this.firstName;
	}


	
	
	
	
}

package com.ebook.model.partner;

import java.util.ArrayList;
import java.util.List;

import com.ebook.model.customer.Customer;
import com.ebook.model.item.Product;

public class Partner extends Customer{
	
	private String partnerID;
	private List<Product> products = new ArrayList<Product>();

	
	public Partner() {}
	
	
	public String getPartnerID() {
		return partnerID;
	}


	public void setPartnerID(String partnerID) {
		this.partnerID = partnerID;
	}


	public List<Product> getProducts() {
		return products;
	}


	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	
}

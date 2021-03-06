package com.ebook.model.item;

public class Product {
	private String id;
	private String title;
	private double price;
	private String partnerId;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setPartnerId(String partnerid){
		this.partnerId = partnerid;
	}

	public String getPartnerId(){
		return partnerId;
	}
}

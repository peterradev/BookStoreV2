package com.ebook.service.representation;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="")
public class ProductRequest {

	private String title;
	private double price;
	private String partnerId;
	
	public ProductRequest() {}
	
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
	
	public void setPartnerId(String partnerId) {
		this.partnerId=partnerId;
	}
	
	public String getPartnerId() {
		return this.partnerId;
	}
	
}

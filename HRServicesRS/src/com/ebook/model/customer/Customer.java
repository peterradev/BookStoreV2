package com.ebook.model.customer;

import java.util.ArrayList;
import java.util.List;

import com.ebook.model.order.Order;

public class Customer {
	private CustomerCard card;
	private String customerId;
	private String lastName;
	private String firstName;
	private Address billingAddress;
	private Address shippingAddress;
	private List<Order> orders = new ArrayList<Order>();

	public List<Order> getOrders() {
		return this.orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public Address getBillingAddress() {
		return this.billingAddress;
	}

	public void setBillingAddress(Address billingAddress) {
		this.billingAddress = billingAddress;
	}

	public Address getShippingAddress() {
		return this.shippingAddress;
	}

	public void setShippingAddress(Address shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public String getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(String id) {
		this.customerId = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void addOrder(Order order) {
		orders.add(order);
	}

	public void addCard(CustomerCard card) {
		this.card = card;
	}

	public CustomerCard getCard() {
		return this.card;
	}
}

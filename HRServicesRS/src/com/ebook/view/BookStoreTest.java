package com.ebook.view;

import com.ebook.model.customer.Customer;
import com.ebook.model.customer.CustomerCard;
import com.ebook.model.item.Product;
import com.ebook.model.item.ProductManager;
import com.ebook.model.order.Order;
import com.ebook.model.order.OrderManager;
import com.ebook.model.partner.Partner;

public class BookStoreTest {

	public static void main(String[] args) {

		System.out.println("Hello");

		Partner p1 = new Partner();
		p1.setPartnerID("XY111");
		p1.setFirstName("John");
		p1.setLastName("Doe");

		System.out.println(p1);

		CustomerCard card = new CustomerCard();

		Customer cust = new Customer();
		cust.setFirstName("Jane");
		cust.setLastName("Doe");

		card.setFirstName(cust.getFirstName());
		card.setLastName(cust.getLastName());
		card.setCardNum("4833985477794465");
		card.setMonth(7);
		card.setYear(27);
		card.setSecurityNum(649);
		card.setZipCode(60596);

		System.out.println(card);

		cust.addCard(card);
		System.out.println(cust.getCard().getCardNum());

		// Cleint will use the order manager to have access to anything related to order
		// functionality
		System.out.println("*********** Creating Order Manager Object **************");

		OrderManager orderMan = new OrderManager();

		System.out.println("BookStoreTest: *************** instantiating a customer and an order");

		Customer c1 = new Customer();
		c1.setFirstName("Billy");
		c1.setLastName("Bob");
		c1.setCustomerId("111111");

		Product p = new Product();

		Order order = new Order();
		order.addProduct(p, 4);
		order.setOrderId("11111");

		orderMan.addOrder(order);
//		orderMan.getOrder(order.getOrderId());

		System.out.println("BookStoreTest: ************** Order is inserted in BookStore Database ************");

		System.out.println("BookStoreTest: ************** trying to search order in the database *************");

//		Order searchedOrder = orderMan.findOrderById("11111");

//		System.out.println("\tName: \t\t\t" + searchedOrder.getOrderId() + " " + searchedOrder.getOrderState() + "\n");

		System.out.println("BookStoreTest: ************* updating the order state in the the database *********");
	
		orderMan.confirmOrder(order);
		
	

	}

}

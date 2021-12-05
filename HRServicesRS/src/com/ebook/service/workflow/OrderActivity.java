package com.ebook.service.workflow;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.ebook.dal.OrderDAO;
import com.ebook.model.order.Order;
import com.ebook.model.order.OrderManager;
import com.ebook.service.representation.OrderRepresentation;

public class OrderActivity {

	private static OrderManager om = new OrderManager();
	private static OrderDAO dao = new OrderDAO();

	public Set<OrderRepresentation> getOrders(){
		Set<Order> orders = new HashSet<Order>();
		Set<OrderRepresentation> orderRepresentations = new HashSet<>();

		orders = dao.getAllOrders();

		Iterator<Order> it = orders.iterator();
		while(it.hasNext()) {
			Order ord = it.next();
			OrderRepresentation orderRepresentation = new OrderRepresentation();
			orderRepresentation.setId(ord.getOrderId());
			orderRepresentation.setOrderStatus(ord.getOrderState());

			orderRepresentations.add(orderRepresentation);
		}
		return orderRepresentations;
	}


	public OrderRepresentation getOrder(String id) {
		Order ord = dao.getOrder(id);

		OrderRepresentation ordRep = new OrderRepresentation();
		ordRep.setId(ord.getOrderId());
		ordRep.setOrderStatus(ord.getOrderState());

		return ordRep;
	}


	// Need to create Order Representation


	public String deleteOrder(String id) {
		dao.deleteOrder(id);
		return "OK";
	}

	public OrderRepresentation createOrder(String orderState) {
		Order ord = dao.addOrder(orderState);
		OrderRepresentation ordRep = new OrderRepresentation();
		ordRep.setId(ord.getOrderId());
		ordRep.setOrderStatus(ord.getOrderState());

		return ordRep;
	}


}

package com.ebook.service;

import java.util.Set;

import com.ebook.service.representation.OrderRepresentation;
import com.ebook.service.representation.OrderRequest;

public interface OrderService {

	public Set<OrderRepresentation> getAllOrders();
	public OrderRepresentation getOrder(String orderId);
	public OrderRepresentation createOrder(OrderRequest orderRequest);
	
}

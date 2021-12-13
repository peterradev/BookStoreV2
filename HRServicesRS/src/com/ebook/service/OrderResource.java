package com.ebook.service;

import java.util.Set;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.cxf.rs.security.cors.CrossOriginResourceSharing;

import com.ebook.service.representation.OrderRepresentation;
import com.ebook.service.representation.OrderRequest;
import com.ebook.service.representation.PartnerRepresentation;
import com.ebook.service.workflow.OrderActivity;
import com.ebook.service.workflow.PartnerActivity;

@CrossOriginResourceSharing(allowAllOrigins = true)

@Path("/orderservice/")
public class OrderResource implements OrderService{

	@GET
	@Produces({"application/xml", "application/json"})
	@Path("/orders")
	public Set<OrderRepresentation> getAllOrders(){
		System.out.println("GET METHOD Request for all orders .....");
		OrderActivity ordActivity = new OrderActivity();
		return ordActivity.getOrders();
	}

	@GET
	@Produces({"application/xml", "application/json"})
	@Path("/order/id/{orderid}")
	public OrderRepresentation getOrder(@PathParam("orderid") String id){
		System.out.println("GET METHOD Request for one order .....");
		OrderActivity ordActivity = new OrderActivity();
		return ordActivity.getOrder(id);
	}

	@POST
	@Produces({"application/xml", "application/json"})
	@Path("/order")
	public OrderRepresentation createOrder(OrderRequest orderRequest){
		System.out.println("POST METHOD Request for order .....");
		OrderActivity ordActivity = new OrderActivity();
		return ordActivity.createOrder(orderRequest.getOrderStatus());
	}

	@DELETE
	@Produces({"application/xml", "application/json"})
	@Path("order/{orderid}")
	public Response deleteOrder(@PathParam("orderid")String id){
		System.out.println("Delete Method request from Client with OrderRequest String ........");
		OrderActivity patActivity = new OrderActivity();
		String res = patActivity.deleteOrder(id);
		if(res.equals("OK")){
			return Response.status(Status.OK).build();
		}
		return null;
	}



}

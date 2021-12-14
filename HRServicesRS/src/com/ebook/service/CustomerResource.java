package com.ebook.service;

import java.sql.ResultSet;
import java.util.Set;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.ebook.service.representation.CustomerRepresentation;
import com.ebook.service.representation.CustomerRequest;
import com.ebook.service.workflow.CustomerActivity;


@Path("/customerservice/")
public class CustomerResource implements CustomerService{

	@GET
	@Produces({"application/xml", "application/json"})
	@Path("/customers")
	public Set<CustomerRepresentation> getCustomers(){
		System.out.println("GET METHOD Request for all customers .....");
		CustomerActivity patActivity = new CustomerActivity();
		return patActivity.getAllCustomers();
	}

	@GET
	@Produces({"application/xml", "applicatoin/json"})
	@Path("customer/id/{customerId}")
	public CustomerRepresentation getCustomer(@PathParam("customerId") String id){
		System.out.println("GET METHOD Request from Client with CustomerRequest string ..........");
		CustomerActivity patActivity = new CustomerActivity();
		return patActivity.getCustomer(id);
	}

	@POST
	@Produces({"application/xml", "application/json"})
	@Path("/customer")
	public ResultSet createCustomer(CustomerRequest customerRequest){
		System.out.println("POST METHOD Request from Client with ......." + customerRequest.getFirstName() + customerRequest.getLastName());
		CustomerActivity patActivity = new CustomerActivity();
		return patActivity.createCustomer(customerRequest.getFirstName(), customerRequest.getLastName());
	}

	@DELETE
	@Produces({"application/xml", "applicatoin/json"})
	@Path("customer/{customerId}")
	public Response deleteCustomer(@PathParam("customerId") String id){
		System.out.println("Delete Method request from Client with CustomerRequest String ........");
		CustomerActivity patActivity = new CustomerActivity();
		String res = patActivity.deleteCustomer(id);
		if(res.equals("OK")){
			return Response.status(Status.OK).build();
		}
		return null;
	}
}

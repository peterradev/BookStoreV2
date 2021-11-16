package com.ebook.model.customer;

// import javax.ws.rs.GET;
// import javax.ws.rs.Path;
// import javax.ws.rs.PathParam;
// import javax.ws.rs.Produces;

// import org.apache.cxf.jaxrs.ext.PATCH;

import com.ebook.dal.CustomerDAO;

// @Path("/customerService/")
public class CustomerManager {

	private CustomerDAO custDAO = new CustomerDAO();

	public Customer getCustomer(String id) {
		Customer customer = findCustomerById(id);
		return customer;
	}

	// search customer by ID from the DB
	public Customer findCustomerById(String customerId) {

		try {
			Customer customer = custDAO.getCustomer(customerId);
			return customer;
		} catch (Exception se) {
			System.err.println("CustomerService: Threw a Exception retrieving customer.");
			System.err.println(se.getMessage());
		}
		return null;
	}

	// Insert a new customer in the DB
	public void addCustomer(Customer customer) {

		try {
			custDAO.addCustomer(customer);
		} catch (Exception se) {
			System.err.println("CustomerService: Threw a Exception retrieving customer.");
			System.err.println(se.getMessage());
		}
	}

}

package com.ebook.service.workflow;

import java.sql.ResultSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.ebook.dal.CustomerDAO;
import com.ebook.domain.Link;
import com.ebook.model.customer.Customer;
import com.ebook.model.customer.CustomerManager;
import com.ebook.service.representation.CustomerRepresentation;

public class CustomerActivity {

	private static CustomerManager pm = new CustomerManager();
	private static CustomerDAO dao = new CustomerDAO();

	public Set<CustomerRepresentation> getAllCustomers(){
		Set<Customer> customers = new  HashSet<>();
		Set<CustomerRepresentation> customerRepresentations = new HashSet<>();

		customers = dao.getAllCustomers();
		Iterator<Customer> it = customers.iterator();
		while(it.hasNext()) {
			Customer cus = (Customer)it.next();
			CustomerRepresentation customerRepresentation = new CustomerRepresentation();
			customerRepresentation.setId(cus.getCustomerId());
			customerRepresentation.setFirstName(cus.getFirstName());
			customerRepresentation.setLastName(cus.getLastName());

			customerRepresentation.setAddress(cus.getBillingAddress());
			setLinks(customerRepresentation,cus.getCustomerId());
					
			customerRepresentations.add(customerRepresentation);
		}
		return customerRepresentations;
	}

	public CustomerRepresentation getCustomer(String id) {
		Customer cus = dao.getCustomer(id);
		CustomerRepresentation cusRep = new CustomerRepresentation();
		cusRep.setFirstName(cus.getFirstName());
		cusRep.setId(cus.getCustomerId());
		cusRep.setLastName(cus.getLastName());
		cusRep.setAddress(cus.getBillingAddress());

		setLinks(cusRep,cus.getCustomerId());
		
		return cusRep;
	}


	public ResultSet createCustomer(String firstName, String lastName) {
		return dao.addCustomer(firstName, lastName);
		
	}

	public String deleteCustomer(String id) {
		pm.deleteCustomer(id);
		return "OK";
	}

	private void setLinks(CustomerRepresentation cusRep, String id){
		Link listOrder = new Link("view", "http://localhost:8081/customerservice/customer/"+id,"application/json+customer");

		cusRep.setLinks(listOrder);
	}

}

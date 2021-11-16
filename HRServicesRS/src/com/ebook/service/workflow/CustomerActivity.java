package com.ebook.service.workflow;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.ws.rs.core.Response;

import com.ebook.dal.CustomerDAO;
import com.ebook.model.customer.Customer;
import com.ebook.model.customer.CustomerManager;
import com.ebook.service.representation.CustomerRepresentation;

public class CustomerActivity {
	
	private static CustomerManager pm = new CustomerManager();
	private static CustomerDAO dao = new CustomerDAO();
	
	public Set<CustomerRepresentation> getAllCustomers(){
		Set<Customer> customers = new  HashSet<>();
		Set<CustomerRepresentation> customerRepresentations = new HashSet<>();
		
		customer = dao.getAllCustomers();
		Iterator<Customer> it = customer.iterator();
		while(it.hasNext()) {
			Customer cus = (Customer)it.next();
			CustomerRepresentation customerRepresentation = new CustomerRepresentation();
			customerRepresentation.setId(cus.getCustomerID());
			customerRepresentation.setFirstName(cus.getFirstName());
			customerRepresentation.setLastName(cus.getLastName());
			
			customerRepresentations.add(customerRepresentation);
		}
		return customerRepresentations;
	}
	
	public CustomerRepresentation getCustomer(String id) {
		Customer pro = dao.getCustomer(id);
		CustomerRepresentation parRep = new CustomerRepresentation();
		parRep.setFirstName(pro.getFirstName());
		parRep.setId(pro.getCustomerID());
		parRep.setLastName(pro.getLastName());
		
		return parRep;
	}
	
	
	public CustomerRepresentation createCustomer(String firstName, String lastName) {
		Customer par = dao.addCustomer(firstName, lastName);
		CustomerRepresentation parRep = new CustomerRepresentation();
		parRep.setFirstName(par.getFirstName());
		parRep.setLastName(par.getLastName());
		parRep.setId(par.getCustomerID());
		
		return parRep;
	}
	
	public String deleteCustomer(String id) {
		pm.deleteCustomer(id);
		return "OK";
	}
	
}

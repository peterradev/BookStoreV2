package com.ebook.service;

import java.sql.ResultSet;
import java.util.Set;

import com.ebook.service.representation.CustomerRepresentation;
import com.ebook.service.representation.CustomerRequest;

public interface CustomerService {

	public Set<CustomerRepresentation> getCustomers();
	public CustomerRepresentation getCustomer(String id);
	public ResultSet createCustomer(CustomerRequest customerRequest);
	
	
}

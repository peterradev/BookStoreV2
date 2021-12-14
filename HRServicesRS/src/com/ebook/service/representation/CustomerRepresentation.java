package com.ebook.service.representation;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.ebook.model.customer.Address;

@XmlRootElement(name = "Customer")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="")
public class CustomerRepresentation extends AbstractRepresentation{
	
	private String id;
	private String firstName;
	private String lastName;
	private Address address;
	
	public CustomerRepresentation() {}

	public String getCustomerId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public void setAddress(Address address) {
		this.address=address;
	}
	
	public Address getAddress() {
		return this.address;
	}
	
}

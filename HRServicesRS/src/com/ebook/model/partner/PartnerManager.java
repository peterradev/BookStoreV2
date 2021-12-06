package com.ebook.model.partner;



import java.util.Set;

import com.ebook.dal.PartnerDAO;
import com.ebook.model.item.Product;


public class PartnerManager {

	private PartnerDAO partDAO = new PartnerDAO();

	public Partner getPartner(String id) {
		Partner partner = findPartnerById(id);
		return partner;
	}

	// search partner by ID from the DB
	public Partner findPartnerById(String partnerId) {

		try {
			Partner partner = partDAO.getPartner(partnerId);
			return partner;
		} catch (Exception se) {
			System.err.println("PartnerService: Threw a Exception retrieving partner.");
			System.err.println(se.getMessage());
		}
		return null;
	}

	// Insert a new partner in the DB
	public void addPartner(Partner partner) {

		try {
			partDAO.addPartner(partner);
		} catch (Exception se) {
			System.err.println("PartnerService: Threw a Exception retrieving partner.");
			System.err.println(se.getMessage());
		}
	}
	
	
	public Set<Partner> getAllPartners(){
		
		try {
			return partDAO.getAllPartners();
		}catch(Exception se) {
			System.err.println("PartnerManager: Threw an Exception addign the data");
			System.err.println(se.getMessage());
			se.printStackTrace();
		}
		return null;
	}
	
	public void deletePartner(String id) {
		
		try {
			partDAO.deletePartner(id);
			System.out.println("PartnerManager: Deleted Partner");
		} catch(Exception se) {
			System.err.println("PartnerManager: Threw an Exception deleting the data");
			System.err.println(se.getMessage());
			se.printStackTrace();
		}
	}
	
	public Set<Partner> findPartner(String name){
		try {
			return partDAO.findPartner(name);
		} catch(Exception se) {
			System.err.println("PartnerManager: Threw an Exception addign the data");
			System.err.println(se.getMessage());
			se.printStackTrace();
		}
		return null;
	}

}

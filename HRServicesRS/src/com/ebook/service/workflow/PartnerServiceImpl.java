package com.ebook.service.workflow;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.ebook.dal.ProductDAO;
import com.ebook.model.item.Product;
import com.ebook.model.item.ProductManager;
import com.ebook.service.representation.ProductRepresentation;

public class PartnerServiceImpl implements PartnerService {
	
	private static PartnerDAO dao = new PartnerDAO();

	public PartnerRepresentation getPartner(String id) {

		Partner partner = new Partner();
		PartnerRepresentation partnerRepresentation = new HashSet<>();

		partner = dao.getPartner(id);

		partnerRepresentation.setPartnerId(partner.id);
		partnerRepresentation.setLastName(partner.lastName);
		partnerRepresentation.setFirstName(partner.firstName);
		
		return partnerRepresentation;
	}


}

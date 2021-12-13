package com.ebook.service.workflow;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.ebook.dal.PartnerDAO;
import com.ebook.domain.Link;
import com.ebook.model.partner.Partner;
import com.ebook.model.partner.PartnerManager;
import com.ebook.service.representation.PartnerRepresentation;

public class PartnerActivity {

	private static PartnerManager pm = new PartnerManager();
	private static PartnerDAO dao = new PartnerDAO();

	public Set<PartnerRepresentation> getAllPartners(){
		Set<Partner> partners = new  HashSet<>();
		Set<PartnerRepresentation> partnerRepresentations = new HashSet<>();

		partners = dao.getAllPartners();
		Iterator<Partner> it = partners.iterator();
		while(it.hasNext()) {
			Partner par = (Partner)it.next();
			PartnerRepresentation partnerRepresentation = new PartnerRepresentation();
			partnerRepresentation.setId(par.getPartnerID());
			partnerRepresentation.setFirstName(par.getFirstName());
			partnerRepresentation.setLastName(par.getLastName());

			//Add link
			setLinks(partnerRepresentation, par.getPartnerID());

			partnerRepresentations.add(partnerRepresentation);
		}
		return partnerRepresentations;
	}

	public PartnerRepresentation getPartner(String id) {
		Partner pro = dao.getPartner(id);
		PartnerRepresentation parRep = new PartnerRepresentation();
		parRep.setFirstName(pro.getFirstName());
		parRep.setId(pro.getPartnerID());
		parRep.setLastName(pro.getLastName());

		setLinks(parRep, id);

		return parRep;
	}
	
	public Set<PartnerRepresentation> findPartner(String name) {
		Set<Partner> partners = new  HashSet<>();
		Set<PartnerRepresentation> partnerRepresentations = new HashSet<>();
		
		partners = dao.findPartner(name);
		Iterator<Partner> it = partners.iterator();
		while(it.hasNext()) {
			Partner par = (Partner)it.next();
			PartnerRepresentation partnerRepresentation = new PartnerRepresentation();
			partnerRepresentation.setId(par.getPartnerID());
			partnerRepresentation.setFirstName(par.getFirstName());
			partnerRepresentation.setLastName(par.getLastName());

			//Add link
			setLinks(partnerRepresentation, par.getPartnerID());
			partnerRepresentations.add(partnerRepresentation);
		}
		return partnerRepresentations;
				
	}


//	public PartnerRepresentation createPartner(String firstName, String lastName) {
//		Partner par = dao.addPartner(firstName, lastName);
//		PartnerRepresentation parRep = new PartnerRepresentation();
//		parRep.setFirstName(par.getFirstName());
//		parRep.setLastName(par.getLastName());
//		parRep.setId(par.getPartnerID());
//
//		return parRep;
//	}

	public String deleteParnter(String id) {
		pm.deletePartner(id);
		return "OK";
	}

	private void setLinks(PartnerRepresentation parRep, String id){
		Link listOrder = new Link("view", "http://localhost:8081/partnerservice/partner/"+id,"application/json");
		Link products = new Link("products", "http://localhost:8081/productservice/product/partners/"+ id ,"application/json");

		parRep.setLinks(listOrder);
		parRep.setLinks(products);
	}

}

package com.ebook.service;

import java.util.Set;

import com.ebook.service.representation.PartnerRepresentation;
import com.ebook.service.representation.ProductRequest;

public interface PartnerService {

	public Set<PartnerRepresentation> getPartners();
	public PartnerRepresentation getPartner(String id);
	public PartnerRepresentation createPartner(ProductRequest partnerRequest);
	
	
}

package com.ebook.service;

import java.util.Set;

import com.ebook.service.representation.PartnerRepresentation;
import com.ebook.service.representation.PartnerRequest;

public interface PartnerService {

	public Set<PartnerRepresentation> getPartners();
	public PartnerRepresentation getPartner(String id);
	public PartnerRepresentation createPartner(PartnerRequest partnerRequest);
	public Set<PartnerRepresentation> findPartner(String name);
	
	
}

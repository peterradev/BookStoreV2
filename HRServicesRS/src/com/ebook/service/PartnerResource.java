package com.ebook.service;

import java.util.Set;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.ebook.service.representation.PartnerRepresentation;
import com.ebook.service.representation.PartnerRequest;
import com.ebook.service.workflow.PartnerActivity;


@Path("/partnerservice/")
public class PartnerResource implements PartnerService{

	@GET
	@Produces({"application/xml", "application/json"})
	@Path("/partners")
	public Set<PartnerRepresentation> getPartners(){
		System.out.println("GET METHOD Request for all partners .....");
		PartnerActivity patActivity = new PartnerActivity();
		return patActivity.getAllPartners();
	}

	@GET
	@Produces({"application/xml", "application/json"})
	@Path("partner/id/{partnerId}")
	public PartnerRepresentation getPartner(@PathParam("partnerId") String id){
		System.out.println("GET METHOD Request from Client with PartnerRequest string ..........");
		PartnerActivity patActivity = new PartnerActivity();
		return patActivity.getPartner(id);
	}

	@POST
	@Produces({"application/xml", "application/json"})
	@Path("/partner")
	public PartnerRepresentation createPartner(PartnerRequest partnerRequest){
		System.out.println("POST METHOD Request from Client with ......." + partnerRequest.getFirstName() + partnerRequest.getLastName());
		PartnerActivity patActivity = new PartnerActivity();
		return patActivity.createPartner(partnerRequest.getFirstName(), partnerRequest.getLastName());
	}

	@DELETE
	@Produces({"application/xml", "application/json"})
	@Path("partner/id/{partnerId}")
	public Response deletePartner(@PathParam("partnerId") String id){
		System.out.println("Delete Method request from Client with PartnerRequest String ........");
		PartnerActivity patActivity = new PartnerActivity();
		String res = patActivity.deleteParnter(id);
		if(res.equals("OK")){
			return Response.status(Status.OK).build();
		}
		return null;
	}
	
	@GET
	@Produces({"application/xml", "application/json"})
	@Path("/partner/find/{name}")
	public Set<PartnerRepresentation> findPartner(@PathParam("name")String name) {
		PartnerActivity partActivity = new PartnerActivity();
		return partActivity.findPartner(name);
	}
	
	
}
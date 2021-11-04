package com.ebook.service;

import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.ebook.service.representation.ProductRepresentation;

@Path("/productservice/")
public class ProductResource {
	
	@GET
	@Produces({"application/xml", "application/json"})
	@Path("/product")
	public Set<ProductRepresentation> getProducts(){
		System.out.println("GET METHOD Request for all products .....");
		ProductActivity proActivity = new ProductActivity();
	}
	
}

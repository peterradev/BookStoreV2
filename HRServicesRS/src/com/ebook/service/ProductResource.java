package com.ebook.service;

import java.util.Set;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.cxf.rs.security.cors.CrossOriginResourceSharing;

import com.ebook.service.representation.ProductRepresentation;
import com.ebook.service.representation.ProductRequest;
import com.ebook.service.workflow.ProductActivity;


@CrossOriginResourceSharing(allowAllOrigins = true)

@Path("/productservice/")
public class ProductResource implements ProductService {

	@GET
	@Produces({"application/xml", "application/json"})
	@Path("/product")
	public Set<ProductRepresentation> getProducts(){
		System.out.println("GET METHOD Request for all products .....");
		ProductActivity proActivity = new ProductActivity();
		return proActivity.getProducts();
	}
	
	
	@Override
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Path("/{productId}")
	public ProductRepresentation getProduct(@PathParam("productId") String id) {
		ProductActivity proActivity = new ProductActivity();
		return proActivity.getProduct(id);
	}
	
//	
//	@GET
//	@Produces({"application/xml", "applicatoin/json"})
//	@Path("product/{productId}")
//	public ProductRepresentation getProduct(@PathParam("productId") String id){
//		System.out.println("GET METHOD Request from Client with productRequest string ..........");
//		ProductActivity proActivity = new ProductActivity();
//		return proActivity.getProduct(id);
//	}

	@POST
	@Produces({"application/xml", "application/json"})
	@Path("/product")
	public ProductRepresentation createProduct(ProductRequest productRequest){
		System.out.println("POST METHOD Request from Client with ......." + productRequest.getTitle() + productRequest.getPrice());
		ProductActivity proActivity = new ProductActivity();
//		return proActivity.createProduct(productRequest.getTitle(), productRequest.getPrice());
		return null;
	}

	@DELETE
	@Produces({"application/xml", "applicatoin/json"})
	@Path("product/{productId}")
	public Response deleteProduct(@PathParam("productId") String id){
		System.out.println("Delete Method request from Client with productRequest String ........");
		ProductActivity proActivity = new ProductActivity();
		String res = proActivity.deleteProduct(id);
		if(res.equals("OK")){
			return Response.status(Status.OK).build();
		}
		return null;
	}
	
	@GET
	@Produces({"application/xml", "application/json"})
	@Path("product/partners/{id}")
	public Set<ProductRepresentation> getProductByPartner(@PathParam("id") String id) {
		ProductActivity proActivity = new ProductActivity();
		return proActivity.getProductByPartner(id);
	}
}

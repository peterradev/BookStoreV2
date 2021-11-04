package com.ebook.service.workflow;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.ebook.model.item.Product;
import com.ebook.model.item.ProductManager;
import com.ebook.service.representation.ProductRepresentation;

public class ProductActivity {

	private static ProductManager pm = new ProductManager();

	public Set<ProductRepresentation> getProducts(){

		Set<Product> products = new HashSet<Product>();
		Set<ProductRepresentation> productRepresentations = new HashSet<ProductRepresentation>();

		// products = pm.getAllProducts();

		Iterator<Product> it = products.iterator();
		while(it.hasNext()){
			Product pro = (Product)it.next();
			ProductRepresentation productRepresentation = new ProductRepresentation();
			productRepresentation.setId(pro.getId());
			productRepresentation.setTitle(pro.getTitle());
			productRepresentation.setPrice(pro.getPrice());

			productRepresentations.add(productRepresentation);
		}
		return productRepresentations;
	}

	public ProductRepresentation getProduct(String id){
		Product pro = pm.getProduct(id);

		ProductRepresentation proRep = new ProductRepresentation();
		proRep.setId(pro.getId());
		proRep.setTitle(pro.getTitle());
		proRep.setPrice(pro.getPrice());

		return proRep;
	}


	public ProductRepresentation createProduct(String title, double price){
		
		
		Product rep = pm.addProduct(title, price);

		ProductRepresentation proRep = new ProductRepresentation();
		proRep.setTitle(rep.getTitle());
		proRep.setPrice(rep.getPrice());

		return proRep;
	}

	public String deleteProduct(String id){

		pm.deleteProduct(id);
		return "OK";
	}

}

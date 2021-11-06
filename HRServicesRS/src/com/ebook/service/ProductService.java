package com.ebook.service;

import java.util.Set;

import com.ebook.service.representation.ProductRepresentation;
import com.ebook.service.representation.ProductRequest;

public interface ProductService {
	
	public Set<ProductRepresentation> getProducts();
	public ProductRepresentation getProduct(String id);
	public ProductRepresentation createProduct(ProductRequest productRequest);

}

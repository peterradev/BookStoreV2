package com.ebook.view;

import com.ebook.model.item.Product;
import com.ebook.model.item.ProductManager;

public class Testing {
	
	public static void main(String args[]) {
		
		Product product = new Product();
		product.setPrice(5.00);
		product.setTitle("Not Best Book Ever");
		
		ProductManager productManager = new ProductManager();
		productManager.addProduct(product.getTitle(), product.getPrice());
		
		
	}

}

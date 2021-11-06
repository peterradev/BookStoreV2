package com.ebook.view;

import java.util.Iterator;
import java.util.Set;

import com.ebook.model.item.Product;
import com.ebook.model.item.ProductManager;
import com.ebook.model.order.OrderManager;

public class Testing {
	
	public static void main(String args[]) {
		OrderManager orderManager = new OrderManager();
		ProductManager productManager = new ProductManager();
		
		Product p = new Product();
		p.setId("XY1111");
		p.setTitle("title");
		p.setPrice(5.00);
		

		Product p2 = new Product();
		p2.setId("XY1113");
		p2.setTitle("title2");
		p2.setPrice(5.00);
		
		productManager.addProduct(p.getTitle(), p.getPrice());
		productManager.addProduct(p2.getTitle(), p2.getPrice());
		
		
		Set<Product> products =productManager.getAllProducts();
		
		Iterator<Product> it = products.iterator();
		while(it.hasNext()) {
			System.out.println(it.next().getTitle());
		}
	}

}

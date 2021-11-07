package com.ebook.view;

import com.ebook.model.item.Product;
import com.ebook.model.item.ProductManager;

public class Testing {
	
	public static void main(String args[]) {
//		OrderManager orderManager = new OrderManager();
		ProductManager productManager = new ProductManager();
//		
		Product p = new Product();
//		p.setId("XY1111");
		p.setTitle("title number 1");
		p.setPrice(5.00);
		

		Product p2 = new Product();
//		p2.setId("XY1112");
		p2.setTitle("title2");
		p2.setPrice(5.00);
		
		Product product = productManager.addProduct(p.getTitle(), p.getPrice());
		System.out.println(product.getId());
		productManager.addProduct(p2.getTitle(), p2.getPrice());
		
		System.out.println(productManager.getAllProducts());
//		
//		
//		Set<Product> products =productManager.getAllProducts();
//		
//		Iterator<Product> it = products.iterator();
//		while(it.hasNext()) {
//			System.out.println(it.next().getTitle());
//		}
//		
//		
//		System.out.println(productManager.getProduct("XY1114").getTitle());
		
//		CustomerManager customerManager = new CustomerManager();
//		Customer c1 = new Customer();
//		c1.setCustomerId("XY1112");
//		c1.setFirstName("jihn");
//		
//		customerManager.addCustomer(c1);
//		System.out.println(customerManager.getCustomer(c1.getCustomerId()).getFirstName());
		
		
	}

}

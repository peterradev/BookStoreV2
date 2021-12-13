package com.ebook.view;

import com.ebook.model.item.Product;
import com.ebook.model.item.ProductManager;
import com.ebook.model.partner.Partner;
import com.ebook.model.partner.PartnerManager;

public class Testing {
	
	public static void main(String args[]) {
		
		Partner p1 = new Partner();
		PartnerManager pm = new PartnerManager();
		p1.setFirstName("Jake");
		p1.setLastName("Long");
		
		Product product = new Product();
		product.setPrice(25);
		product.setTitle("this book cost 30 dollars");
		
		Partner p2 = pm.addPartner(p1);
		product.setPartnerId(p2.getPartnerID());
		ProductManager prodMan = new ProductManager();
		Product pro = prodMan.addProduct(product.getTitle(), product.getPrice(), product.getPartnerId());
		System.out.println(pro.getPrice());
	}

}

package com.ebook.view;

import com.ebook.model.partner.Partner;
import com.ebook.model.partner.PartnerManager;

public class Testing {
	
	public static void main(String args[]) {
		
		Partner p1 = new Partner();
		Partner p2 = new Partner();
		Partner p3 = new Partner();
		
		p1.setFirstName("John");
		p1.setLastName("Hill");

		p2.setFirstName("Jonathan");
		p2.setLastName("Baker");
		
		p3.setFirstName("Jack");
		p3.setLastName("Black");
		
		PartnerManager pm = new PartnerManager();
		pm.addPartner(p3);
		pm.addPartner(p1);
		pm.addPartner(p2);
		
	}

}

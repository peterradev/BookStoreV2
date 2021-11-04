package com.ebook.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.ebook.model.customer.Address;
import com.ebook.model.partner.Partner;

public class PartnerDAO {
	public PartnerDAO() {}
	
	public Partner getPartner(String partnerId) {
		 	 
	    try { 		
	    	//Get Partner
	    	Statement st = DBHelper.getConnection().createStatement();
	    	String selectPartnerQuery = "SELECT partnerID, last_name, first_name FROM Partner WHERE partnerID = '" + partnerId + "'";

	    	ResultSet parRS = st.executeQuery(selectPartnerQuery);      
	    	System.out.println("PartnerDAO: *************** Query " + selectPartnerQuery);
	    	
	      //Get Partner
	    	Partner partner = new Partner();
	      while ( parRS.next() ) {
	    	  partner.setPartnerID(parRS.getString("partnerID"));
	    	  partner.setLastName(parRS.getString("last_name"));
	    	  partner.setFirstName(parRS.getString("first_name"));
	      }
	      //close to manage resources
	      parRS.close();
	      	    		  
	      //Get Address
//	      String selectAddressQuery = "SELECT addressID, street, unit, city, state, zip FROM Address WHERE PartnerID = '" + partnerId + "'";
//	      ResultSet addRS = st.executeQuery(selectAddressQuery);
//    	  Address address = new Address();
//    	  
//    	  System.out.println("PartnerDAO: *************** Query " + selectAddressQuery);
//    	  
//	      while ( addRS.next() ) {
//	    	  address.setAddressId(addRS.getString("addressid"));
//	    	  address.setStreet(addRS.getString("street"));
//	    	  address.setUnit(addRS.getString("unit"));
//	    	  address.setCity(addRS.getString("city"));
//	    	  address.setState(addRS.getString("state"));
//	    	  address.setZip(addRS.getString("zip"));
//	      }
//	      
//	      partner.setBillingAddress(address);
//	      //close to manage resources
//	      addRS.close();
//	      st.close();
	      
	      return partner;
	    }	    
	    catch (SQLException se) {
	      System.err.println("PartnerDAO: Threw a SQLException retrieving the partner object.");
	      System.err.println(se.getMessage());
	      se.printStackTrace();
	    }
	    
	    return null;
	  }
	
	public void addPartner(Partner par) {
		Connection con = DBHelper.getConnection();
        PreparedStatement parPst = null;
        PreparedStatement addPst = null;

        try {
        	//Insert the partner object
            String parStm = "INSERT INTO Partner(partnerID, last_name, first_name) VALUES(?, ?, ?)";
            parPst = con.prepareStatement(parStm);
            parPst.setString(1, par.getPartnerID());
            parPst.setString(2, par.getLastName());       
            parPst.setString(3, par.getFirstName()); 
            parPst.executeUpdate();

        	//Insert the partner address object
//            String addStm = "INSERT INTO Address(partnerID, addressID, street, unit, city, state, zip) VALUES(?, ?, ?, ?, ?, ?, ?)";
//            addPst = con.prepareStatement(addStm);
//            addPst.setString(1, par.getPartnerId());
//            addPst.setString(2, par.getBillingAddress().getAddressId());  
//            addPst.setString(3, par.getBillingAddress().getStreet());       
//            addPst.setString(4, par.getBillingAddress().getUnit());  
//            addPst.setString(5, par.getBillingAddress().getCity());  
//            addPst.setString(6, par.getBillingAddress().getState());      
//            addPst.setString(7, par.getBillingAddress().getZip());  
//            addPst.executeUpdate();
        } catch (SQLException ex) {

        } finally {

            try {
                if (addPst != null) {
                	addPst.close();
                	parPst.close();
                }
                if (con != null) {
                    con.close();
                }

            } catch (SQLException ex) {
      	      System.err.println("PartnerDAO: Threw a SQLException saving the partner object.");
    	      System.err.println(ex.getMessage());
            }
        }
    }
}

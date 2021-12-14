package com.ebook.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import com.ebook.model.customer.Address;
import com.ebook.model.customer.Customer;
import com.ebook.model.item.Product;

public class CustomerDAO {
	public CustomerDAO() {}

	public Customer getCustomer(String customerId) {

		Customer customer = new Customer();
		
	    try {
	    	//Get Customer
	    	Statement st = DBHelper.getConnection().createStatement();
	    	String selectCustomerQuery = "SELECT customerID, last_name, first_name FROM customer WHERE customerID = '" + customerId + "'";

	    	ResultSet custRS = st.executeQuery(selectCustomerQuery);
	    	System.out.println("CustomerDAO: *************** Query " + selectCustomerQuery);

	      //Get Customer
    	  
	      while ( custRS.next() ) {
	    	  customer.setCustomerId(custRS.getString("customerID"));
	    	  customer.setLastName(custRS.getString("last_name"));
	    	  customer.setFirstName(custRS.getString("first_name"));
	      }
	      //close to manage resources
	      custRS.close();

	      // Get Address
	      String selectAddressQuery = "SELECT addressID, street, unit, city, state, zip FROM Address WHERE customerID = '" + customerId + "'";
	      ResultSet addRS = st.executeQuery(selectAddressQuery);
   	  
	      Address address = new Address();

   	      System.out.println("CustomerDAO: *************** Query " + selectAddressQuery);

	      while ( addRS.next() ) {
	    	  address.setAddressId(addRS.getString("addressid"));
	    	  address.setStreet(addRS.getString("street"));
	    	  address.setUnit(addRS.getString("unit"));
	    	  address.setCity(addRS.getString("city"));
	    	  address.setState(addRS.getString("state"));
	    	  address.setZip(addRS.getString("zip"));
	      }

	      customer.setBillingAddress(address);
	      //close to manage resources
	      addRS.close();
	      st.close();

	    }
	    catch (SQLException se) {
	      System.err.println("CustomerDAO: Threw a SQLException retrieving the customer object.");
	      System.err.println(se.getMessage());
	      se.printStackTrace();
	    }

	    return customer;
	  }

	public void addCustomer(Customer cust) {
		Connection con = DBHelper.getConnection();
        PreparedStatement custPst = null;
        PreparedStatement addPst = null;

        try {
        	//Insert the customer object
            String custStm = "INSERT INTO customer(customerID, last_name, first_name) VALUES(?, ?, ?)";
            custPst = con.prepareStatement(custStm);
            custPst.setString(1, cust.getCustomerId());
            custPst.setString(2, cust.getLastName());
            custPst.setString(3, cust.getFirstName());
            custPst.executeUpdate();

        	// Insert the customer address object
					String addStm = "INSERT INTO Address(customerID, addressID, street, unit, city, state, zip) VALUES(?, ?, ?, ?, ?, ?, ?)";
           addPst = con.prepareStatement(addStm);
           addPst.setString(1, cust.getCustomerId());
           addPst.setString(2, cust.getBillingAddress().getAddressId());
           addPst.setString(3, cust.getBillingAddress().getStreet());
           addPst.setString(4, cust.getBillingAddress().getUnit());
           addPst.setString(5, cust.getBillingAddress().getCity());
           addPst.setString(6, cust.getBillingAddress().getState());
           addPst.setString(7, cust.getBillingAddress().getZip());
           addPst.executeUpdate();
        } catch (SQLException ex) {

        } finally {

            try {
                if (addPst != null) {
                	addPst.close();
                	custPst.close();
                }
                if (con != null) {
                    con.close();
                }

            } catch (SQLException ex) {
      	      System.err.println("CustomerDAO: Threw a SQLException saving the customer object.");
    	      System.err.println(ex.getMessage());
            }
        }
    }
	
	public Set<Customer> getAllCustomers() {
			
		Set<Customer> customers = new HashSet<>();

		try{
			
			Statement st = DBHelper.getConnection().createStatement();
			String selectCustomerQuery = "SELECT * FROM customer";

			ResultSet customerRS = st.executeQuery(selectCustomerQuery);
			System.out.println("ItemSearch: *********** Query "+ selectCustomerQuery);

			while(customerRS.next()) {
				Customer customer = new Customer();
				customer.setCustomerId(customerRS.getString("customerid"));
				customer.setFirstName(customerRS.getString("first_name"));
				customer.setLastName(customerRS.getString("last_name"));
				
				customers.add(customer);
			}

			customerRS.close();
			
		} catch (SQLException se){
			System.err.println("ProductDAO: Threw a SQLException retrieving the data");
			System.err.println(se.getMessage());
			se.printStackTrace();
		}
		return customers;
	}
	
	public ResultSet addCustomer(String firstName, String lastName) {
		Customer customer = new Customer();
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(10000);
		
		String id = "CS" + randomInt;
		
		customer.setCustomerId(id);
		customer.setFirstName(firstName);
		customer.setLastName(lastName);
		
		
		Connection con = DBHelper.getConnection();
		PreparedStatement custPst = null;
		
		try {
			String custStm = "INSERT INTO customer(customerid, first_name, last_name) VALUES(?, ?, ?)";
			
			custPst = con.prepareStatement(custStm);
			custPst.setString(1, customer.getCustomerId());
			custPst.setString(2, customer.getFirstName());
			custPst.setString(3, customer.getLastName());
			
			return custPst.executeQuery();
			
		} catch(SQLException ex) {
			
		}finally {
			try {
				if(con != null) {
					con.close();
				}
			}catch(SQLException ex) {
					System.err.println("CustomerDAO: Threw a SQLException saving the customer");
					System.err.println(ex.getMessage());
					ex.printStackTrace();
				}
			}
		
			return null;
		}
	
	
	public int deleteCustomer(String id) {
		Connection con = DBHelper.getConnection();
		String sql = "DELETE FROM customer WHERE customerID = ?";
		int result = -1;
		
		try{
			PreparedStatement custPst = con.prepareStatement(sql);
			custPst.setString(1, id);
			result= custPst.executeUpdate();
		} catch(SQLException se){
			System.err.println("ProductDAO: Threw a SQLException deleting customer.");
			System.err.println(se.getMessage());
			se.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	
}

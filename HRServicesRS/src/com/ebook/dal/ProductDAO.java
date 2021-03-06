package com.ebook.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import com.ebook.model.item.Product;


public class ProductDAO{

//	private static Set<Product> products = new HashSet<>();


	public ProductDAO() {}

	public Product getProduct(String productID) {

		try {
			Statement st = DBHelper.getConnection().createStatement();
			String selectProductQuery = "SELECT productId, title, price, partnerid  FROM product WHERE productid = '" + productID + "'";

			ResultSet productRS = st.executeQuery(selectProductQuery);
			System.out.println("ItemSearch: *********** Query "+ selectProductQuery);

			Product product = new Product();
			while(productRS.next()) {
				product.setId(productRS.getString("productId"));
				product.setTitle(productRS.getString("title"));
				product.setPrice(productRS.getDouble("price"));
				product.setPartnerId(productRS.getString("partnerid"));
			}

			productRS.close();

			return product;

		}
		catch(SQLException se) {
			System.err.println("ItemSearch: Threw a SQLException retrieving the product object.");
		    System.err.println(se.getMessage());
		    se.printStackTrace();
		}

		return null;
	}

	public Product addItem(String title, double price, String partnerid) {
		
			Product product = new Product();
			Random randomGenerator = new Random();
			// Randomly create a productId
			int randomInt = randomGenerator.nextInt(10000);
			String id = "XY" + randomInt;

			product.setId(id);
			product.setTitle(title);
			product.setPrice(price);
			product.setPartnerId(partnerid);

			Connection con = DBHelper.getConnection();
			PreparedStatement itemPst = null;

			try {
				String itemStm =  "INSERT INTO product(productid, title, price, partnerid) VALUES(?, ?, ?, ?)";
				itemPst = con.prepareStatement(itemStm);
				itemPst.setString(1, product.getId());
				itemPst.setString(2, product.getTitle());
				itemPst.setFloat(3, (float) product.getPrice());
				itemPst.setString(4, product.getPartnerId());
				itemPst.executeUpdate();
				return product;
			} catch(SQLException ex) {

			} finally {
				try {
					 if (con != null) {
						 con.close();
					 }
				} catch(SQLException ex) {
					System.err.println("ItemSearch: Threw a SQLException saving the product object.");
					System.err.println(ex.getMessage());
				}
			}
		
        return null;
	}


	public int deleteProduct(String id) {
		Connection con = DBHelper.getConnection();
		
		String sql = "DELETE FROM product WHERE productID = ?";
		int result=-1;
		try{
			PreparedStatement itemPst = con.prepareStatement(sql);
			itemPst.setString(1, id);
			result = itemPst.executeUpdate();
		} catch(SQLException se){
			System.err.println("ProductDAO: Threw a SQLException deleting product.");
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
	
	
	public Set<Product> getProductByPartner(String id){
		
		Set<Product> products = new HashSet<>();
		
		try {
			Statement st = DBHelper.getConnection().createStatement();
			String selectProductQuery = "SELECT * from product where partnerid='"+id+"'";
			
			ResultSet productRS = st.executeQuery(selectProductQuery);
			
			while(productRS.next()) {
				Product product = new Product();
				product.setTitle(productRS.getString("title"));
				product.setPrice(productRS.getDouble("price"));
//s				product.setPartnerId(productRS.getString("partnerid"));
				product.setPartnerId(productRS.getString("partnerid"));
				products.add(product);
				System.out.println("Getting Product: " + product.getTitle());
			}
			productRS.close();
			return products;
		} catch(SQLException se) {
			System.err.println("ProductDAO: Threw a SQLException retrieving the data");
			System.err.println(se.getMessage());
			se.printStackTrace();
		}
		return products;
	}


	public Set<Product> getAllProducts() {

		Set<Product> products = new HashSet<>();

		try{

			Statement st = DBHelper.getConnection().createStatement();
			String selectProductQuery = "SELECT * FROM product";

			ResultSet productRS = st.executeQuery(selectProductQuery);
			System.out.println("ItemSearch: *********** Query "+ selectProductQuery);

			while(productRS.next()) {
				// Create a new product object
				Product product = new Product();
				product.setId(productRS.getString("productid"));
				product.setTitle(productRS.getString("title"));
				product.setPrice(productRS.getDouble("price"));
//s				product.setPartnerId(productRS.getString("partnerid"));
				product.setPartnerId(productRS.getString("partnerid"));

				// Now add this product object to the Set
				products.add(product);

			}

			productRS.close();
			return products;

		} catch (SQLException se){
			System.err.println("ProductDAO: Threw a SQLException retrieving the data");
			System.err.println(se.getMessage());
			se.printStackTrace();
		}
		return products;

	}
}

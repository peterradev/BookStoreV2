package com.ebook.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import com.ebook.model.item.Product;


public class ProductDAO{
	
	private String id = "XY1111";

	public ProductDAO() {}

	public Product getProduct(String productID) {

		try {
			Statement st = DBHelper.getConnection().createStatement();
			String selectProductQuery = "SELECT id, title, price FROM products WHERE id = '" + productID + "'";

			ResultSet productRS = st.executeQuery(selectProductQuery);
			System.out.println("ItemSearch: *********** Query "+ selectProductQuery);

			Product product = new Product();
			while(productRS.next()) {
				product.setId(productRS.getString("id"));
				product.setTitle(productRS.getString("title"));
				product.setPrice(productRS.getDouble("price"));
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

	public void addItem(Product product) {
		Connection con = DBHelper.getConnection();
        PreparedStatement itemPst = null;

        try {
        	String itemStm =  "INSERT INTO products(productid, title, price) VALUES(?, ?, ?)";
        	itemPst = con.prepareStatement(itemStm);
        	itemPst.setString(1, product.getId());
        	itemPst.setString(2, product.getTitle());
        	itemPst.setFloat(3, (float) product.getPrice());
        	itemPst.executeUpdate();
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
	}


	public void deleteProduct(String id) {
		Connection con = DBHelper.getConnection();
		String sql = "DELETE FROM products WHERE productID = ?";
		try{
			PreparedStatement itemPst = con.prepareStatement(sql);
			itemPst.setString(1, id);
			itemPst.executeUpdate();
		} catch(SQLException se){
			System.err.println("ProductDAO: Threw a SQLException deleting product.");
			System.err.println(se.getMessage());
			se.printStackTrace();
		}

	}


	public Set<Product> getAllProducts() {

		try{
			Statement st = DBHelper.getConnection().createStatement();
			String selectProductQuery = "SELECT * FROM products ";

			ResultSet productRS = st.executeQuery(selectProductQuery);
			System.out.println("ItemSearch: *********** Query "+ selectProductQuery);

			Set<Product> products = new HashSet<Product>();
			Product product = new Product();

			while(productRS.next()) {
				product.setId(productRS.getString("productid"));
				product.setTitle(productRS.getString("title"));
				product.setPrice(productRS.getFloat("price"));
				products.add(product);
			}

			productRS.close();

			return products;
		} catch (SQLException se){
			System.err.println("ProductDAO: Threw a SQLException retrieving the data");
			System.err.println(se.getMessage());
			se.printStackTrace();
		}
		return null;

	}


}

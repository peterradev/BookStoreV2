package com.ebook.model.item;

import java.util.Set;

import com.ebook.dal.ProductDAO;

public class ProductManager {


	private static ProductDAO itemSearch = new ProductDAO();

	public Product getProduct(String productID) {
		Product product = findProductByID(productID);
		return product;
	}


	public Product findProductByID(String productID) {

		try {
			Product product = itemSearch.getProduct(productID);
			return product;
		} catch (Exception se) {
			System.err.println("ProductManager: Threw an Exception retrieving product.");
			System.err.print(se.getMessage());
		}

		return null;
	}

	public int deleteProduct(String productId) {

		int result = -1;
		try {
			result = itemSearch.deleteProduct(productId);
		} catch(Exception se) {
			System.err.println("ProductManager: Threw an Exception deleting the data");
			System.err.println(se.getMessage());
			se.printStackTrace();
		}
		
	}

	public Product addProduct(String title, double price, String partnerid) {
		
		

		try{
			Product product = itemSearch.addItem(title, price, partnerid);
			System.out.println("ProductManager: Product Added");
			return product;
		} catch(Exception se) {
			System.err.println("ProductManager: Threw an Exception addign the data");
			System.err.println(se.getMessage());
			se.printStackTrace();
		}
		return null;

	}
	
	
	public Set<Product> getAllProducts() {
		
		
		
		try {
			return itemSearch.getAllProducts();
		}catch(Exception se) {
			System.err.println("ProductManager: Threw an Exception addign the data");
			System.err.println(se.getMessage());
			se.printStackTrace();
		}
		return null;
	}




}

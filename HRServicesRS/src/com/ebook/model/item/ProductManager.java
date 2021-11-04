package com.ebook.model.item;

import com.ebook.dal.ProductDAO;

public class ProductManager {


	private ProductDAO itemSearch = new ProductDAO();

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

	public void deleteProduct(String productId) {

		try {
			itemSearch.deleteProduct(productId);
			System.out.println("ProductManager: Deleted Product");
		} catch(Exception se) {
			System.err.println("ProductManager: Threw an Exception deleting the data");
			System.err.println(se.getMessage());
			se.printStackTrace();
		}

	}

	public Product addProduct(String title, double price) {
		Product product = new Product();
		product.setTitle(title);
		product.setPrice(price);

		try{
			itemSearch.addItem(product);
			System.out.println("ProductManager: Product Added");
			return product;
		} catch(Exception se) {
			System.err.println("ProductManager: Threw an Exception addign the data");
			System.err.println(se.getMessage());
			se.printStackTrace();
		}
		return null;

	}




}

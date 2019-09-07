package com.niit.dao;

import java.util.List;

import com.niit.model.Product;

public interface ProductDAO {
	List<Product> getAllProducts();
	boolean addProduct(Product product);
	boolean updateProduct(Product product);
	boolean deleteProduct(int productId);
	Product getProductByID(int productId);
	
}
 
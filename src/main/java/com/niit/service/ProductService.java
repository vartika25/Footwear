package com.niit.service;

import java.util.List;

import com.niit.model.Product;

public interface ProductService {

	List<Product> getAllProducts();
	boolean addProduct(Product product);
	boolean updateProduct(Product product);
	boolean deleteProduct(int productId);
	Product getProductByID(int productId);
}

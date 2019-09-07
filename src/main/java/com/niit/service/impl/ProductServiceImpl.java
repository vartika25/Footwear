package com.niit.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.dao.ProductDAO;
import com.niit.model.Product;
import com.niit.service.ProductService;

@Service(value="productService")
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductDAO productDao;
	
	public List<Product> getAllProducts() {
		List<Product> allProducts = productDao.getAllProducts();
		if(allProducts != null)
		{
			return allProducts;
		}
		else
		{
			return new ArrayList<>();
		}
	}

	public boolean addProduct(Product product) {
		return productDao.addProduct(product);
	}

	@Override
	public boolean updateProduct(Product product) {
		// TODO Auto-generated method stub
		return productDao.updateProduct(product);
	}

	@Override
	public boolean deleteProduct(int productId) {
		// TODO Auto-generated method stub
		return productDao.deleteProduct(productId);
	}

	@Override
	public Product getProductByID(int productId) {
		// TODO Auto-generated method stub
		return productDao.getProductByID(productId);
	}

}

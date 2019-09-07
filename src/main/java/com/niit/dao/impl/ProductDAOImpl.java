package com.niit.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.dao.ProductDAO;
import com.niit.model.Product;

@Repository(value="productDao")
public class ProductDAOImpl implements ProductDAO{

	@Autowired
	private SessionFactory sessionFactory;
	private Session session;
	public ProductDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public List<Product> getAllProducts() {
		List<Product> allProducts = new ArrayList<>();
		try
		{
			session = sessionFactory.getCurrentSession();
			allProducts = session.createQuery("from Product").list();
			return allProducts;
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return null;
		}
	}

	@Transactional
	public boolean addProduct(Product product) {
		try
		{		
			session = sessionFactory.getCurrentSession();
			session.save(product);
			session.flush();
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
	}

	@Transactional
	public boolean updateProduct(Product product) {
		try
		{		
			session = sessionFactory.getCurrentSession();
			session.update(product);
			session.flush();
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
	}

	@Transactional
	public boolean deleteProduct(int productId) {
		try
		{		
			session = sessionFactory.getCurrentSession();
			Product product = getProductByID(productId);
			session.delete(product);
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
	}

	@Transactional
	public Product getProductByID(int productId) {
		try
		{
			session = sessionFactory.getCurrentSession();
			Product product = session.get(Product.class,productId);
			return product;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return null;
		}
	}


}

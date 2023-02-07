package com.unitral.order_service.service;

import java.util.List;

import com.unitral.order_service.dao.Product;


public interface Service {
	public List<Product>getAll();
	Product addProduct(Product newProduct);
	Product updateProduct(Product newProduct);
	public void deleteProduct(int id);
	List<Product> getCat(List<String> ls);
	public int checkoutWithUserId(int userId);
	
	

}

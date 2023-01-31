package com.unitral.order_service.service;

import java.util.List;

import com.unitral.order_service.dao.Product;


public interface Service {
	public List<Product>getAll();
	public Product updateProduct();
	public Product addProduct();
	public void deleteProduct();
	
	

}

package com.unitral.catalogue_service.sevice;



import java.util.List;

import com.unitral.catalogue_service.dao.Products;

public interface Service  {
	public List<Products> getProducts();
	public Products updateProducts(Products newProduct);
	public void deleteProducts(String id);
	public Products addProducts(Products newProduct);
	

}

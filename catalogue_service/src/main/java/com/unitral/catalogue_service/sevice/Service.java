package com.unitral.catalogue_service.sevice;



import java.util.List;

import com.unitral.catalogue_service.dao.Products;

public interface Service  {
	public List<Products> getProducts();
	public List<Products> updateProducts(Products newProduct);
	public void deleteProducts(int id);
	public Products addProducts(Products newProduct);
	

}

package com.unitral.catalogue_service.sevice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.unitral.catalogue_service.dao.Products;
import com.unitral.catalogue_service.repository.CatalogueRepository;

@org.springframework.stereotype.Service
public class Service_Imp implements Service{
	boolean b=true;
	@Autowired
	private CatalogueRepository crepo;



	@Override
	public List<Products> getProducts() {
		if(b) {f();b=false;}
		
		return crepo.findAll();
	}
	void f(){
			
		crepo.save(new Products("Physics Book",10));
		crepo.save(new Products("Maths Book",14));
		crepo.save(new Products("Chemistry Book",18));
		crepo.save(new Products("Java Book",110));
	
	}
	
	
	@Override
	public Products addProducts(Products newProduct) {
		
		return crepo.save(new Products
				(newProduct.getProductName(),newProduct.getProductprice() ));
	}
	
	
	@Override
	public List<Products> updateProducts(Products newProduct) {
		
		return null;
	}
	
	@Override
	public void deleteProducts(int id) {
		if(!crepo.existsById(id))return;
		crepo.deleteById(id);
		
	}
	
	
	


}

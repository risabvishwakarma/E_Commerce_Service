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
		if(b){f();b=false;}
		
		return crepo.findAll();
	}
	
	void f(){
			
		crepo.save(new Products("user1","Physics",1));
		crepo.save(new Products("user2","Maths",1));
		crepo.save(new Products("user3","Chemistry",1));
		crepo.save(new Products("user4","Java",1));
	
	}
	
	
	@Override
	public Products addProducts(Products newProduct) {
		newProduct.setMapId(newProduct.getUserId()+newProduct.getProductId());
		
		return crepo.existsById(newProduct.getMapId())?
		updateProducts(newProduct)
		:crepo.save(newProduct);
	
	}
	
	
	@Override
	public Products updateProducts(Products newProduct) {
		
		return crepo.findById(newProduct.getMapId())
			      .map(savedProduct -> {
			        savedProduct.setProductQuantity(
			        		savedProduct.getProductQuantity()+newProduct.getProductQuantity()
			        		);
			        return crepo.save(savedProduct);
			      })
			      .orElseGet(() -> {
			    	 return addProducts(newProduct);
			    	  
			      });
	}
	
	@Override
	public void deleteProducts(String id) {
		
		if(!crepo.existsById(id))return;
		crepo.deleteById(id);
		
	}
	
	
	


}

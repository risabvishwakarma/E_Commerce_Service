package com.unitral.order_service.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.RequestBody;

import com.unitral.order_service.controler.repositories.Order_Repository;
import com.unitral.order_service.dao.Product;

@org.springframework.stereotype.Service
public class Service_Imp  implements Service{
	boolean b=true;
	
	@Autowired
	private Order_Repository orepo;

	public Service_Imp() {
		
	}
	

	@Override
	public List<Product> getAll() {
		if(b) {f();b=false;}
		
		return orepo.findAll();
	}

	@Override
	public Product updateProduct(@RequestBody Product newProduct) {
		
		return orepo.findById(newProduct.getId()).map(dbProduct->{
			dbProduct.setProductAvQuantity(newProduct.getProductAvQuantity());
			dbProduct.setProductPrice(newProduct.getProductPrice());
			return orepo.save(dbProduct);
		}).orElseGet(() -> {
	    	 return addProduct(newProduct);
	      });
		

		
	}

	@Override
	public Product addProduct(Product newProduct) {
		
	Product	product=orepo.findByProductNameAndProductId(newProduct.getProductName(),newProduct.getProductId());
	//System.out.println(product==null?"NULL":product.getProductName());
		return product==null?orepo.save(newProduct):product;
	
	}


	@Override
	public void deleteProduct(int deleteId) {
		if(!orepo.existsById(deleteId))return;
		 orepo.deleteById(deleteId); 
		
	}
	
	void f() {
		orepo.save(new Product("R112","Physics",100,45,"Study",1));
		orepo.save(new Product("R113","Led",105,25,"Electric",5));
		orepo.save(new Product("R114","Pen",160,457,"Study",2));
		orepo.save(new Product("R115","Clothes",190,450,"Others",9));
	}

	

}

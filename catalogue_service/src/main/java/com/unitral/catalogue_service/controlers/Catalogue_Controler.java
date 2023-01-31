package com.unitral.catalogue_service.controlers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.unitral.catalogue_service.dao.Products;

import com.unitral.catalogue_service.sevice.Service;

@RestController
public class Catalogue_Controler {
	@Autowired
	private Service service;
	
	
	
	@GetMapping("/")
	public List<Products> get_Products(){
		return service.getProducts();
		
	}
	@PostMapping("/")
	public Products Post_Products(
			@RequestBody Products newProduct
			
			){
		return service.addProducts(newProduct);
		
	}
	@PutMapping("/")
	public List<Products> Put_Products(){
		return null;
		
	}
	@DeleteMapping("/{id}")
	public void Delete_Products(@PathVariable String id){
	
		service.deleteProducts(id);
		
	}

	

}

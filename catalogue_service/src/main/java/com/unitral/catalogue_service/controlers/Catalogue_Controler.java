package com.unitral.catalogue_service.controlers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unitral.catalogue_service.dao.Products;
import com.unitral.catalogue_service.repository.ProxyInterface;
import com.unitral.catalogue_service.sevice.Service;

@RestController
@RequestMapping("/catalogue")
public class Catalogue_Controler {
	@Autowired
	private Service service;
	
	@Autowired
	private ProxyInterface pi;
	
	
	@GetMapping("/test")
	public List<Products> test_Products(){
		Map<String,Products> list=new HashMap<>();
		StringBuffer sb=new StringBuffer();
		service.getProducts().forEach(pro->{
			//System.out.println(pro.getProductId());
			list.put(pro.getProductId(),pro);
			sb.append(pro.getProductId());
			sb.append(":");
			
		});
		List<Products> productFromOrderService=pi.getOrderedProducts(sb.toString());
		for(Products p:productFromOrderService) {
			p.setProductQuantity(list.get(p.getProductId()).getProductQuantity());
			p.setUserId(list.get(p.getProductId()).getUserId());
			p.setMapId(list.get(p.getProductId()).getMapId());
			
		}
//		for(Map.Entry<String, Products> mp:list.entrySet()) {
//			
//		}
		//System.out.println(ls.size());
		
		return productFromOrderService;
		
	}
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

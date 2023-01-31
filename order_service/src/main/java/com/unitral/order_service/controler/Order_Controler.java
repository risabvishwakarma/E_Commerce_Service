package com.unitral.order_service.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unitral.order_service.dao.Product;
import com.unitral.order_service.service.Service;

@RestController
public class Order_Controler {

	@Autowired
	private Service service ;
	
	@GetMapping("/")
	public List<Product> getAll(){
			return service.getAll();
		}
	

}

package com.unitral.catalogue_service.repository;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.unitral.catalogue_service.dao.Products;


@FeignClient(name="order-service")
public interface ProxyInterface {
	
	@GetMapping("/order/{ls}")
	List<Products> getOrderedProducts(@PathVariable String ls);  //must write @PathVariable 
	
	@GetMapping("/order/quantity/{prodictId}")
	int getAvialableQuantity(@PathVariable int prodictId);

}

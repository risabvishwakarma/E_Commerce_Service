package com.unitral.order_service.repositories;

import java.util.List;
import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.unitral.order_service.dao.CatalogueProduct;

@FeignClient(name="catalogue-service")
public interface ProxyCatalogue {
	
	@GetMapping("/catalogue/{userId}")
	Map<Integer,Integer>  getProducts(@PathVariable int userId);
	

}

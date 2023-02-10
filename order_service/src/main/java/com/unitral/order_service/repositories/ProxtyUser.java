package com.unitral.order_service.repositories;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="user-service")
public interface ProxtyUser {
	
	@GetMapping("/user/check/{id}")
	String isThereUserPresent(@PathVariable int id);

}

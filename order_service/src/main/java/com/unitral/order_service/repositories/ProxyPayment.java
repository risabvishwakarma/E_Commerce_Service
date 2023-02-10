package com.unitral.order_service.repositories;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import jakarta.ws.rs.Path;

@FeignClient(name="payment-service")
public interface ProxyPayment {
	
	@GetMapping("/payment/{RsMid}")
	int makepayment(@PathVariable String RsMid);

}

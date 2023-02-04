package com.unitral.payment_service.Proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;


@FeignClient(name="notification-service")
public interface ProxyConnection {

	@GetMapping("/notification/payDone")
	String payDone();
	
	@GetMapping("/notification/payFailed")
	String payFailed();

}

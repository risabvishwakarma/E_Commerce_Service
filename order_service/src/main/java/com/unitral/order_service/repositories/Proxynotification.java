package com.unitral.order_service.repositories;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="notification-service")
public interface Proxynotification {
	@GetMapping("/notification/payDone/{RsMid}")
	void notify(@PathVariable String RsMid);

}

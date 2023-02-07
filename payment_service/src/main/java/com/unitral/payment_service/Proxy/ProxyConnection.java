package com.unitral.payment_service.Proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name="notification-service")
public interface ProxyConnection {

	@GetMapping("/notification/payDone/{RsMid}")  //0-mail,1-msj
	public boolean payDone(@PathVariable String RsMid);


}

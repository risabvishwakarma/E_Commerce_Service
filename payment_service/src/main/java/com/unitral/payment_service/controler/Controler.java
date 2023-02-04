package com.unitral.payment_service.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unitral.payment_service.Proxy.ProxyConnection;

@RestController
@RequestMapping("/payment")
public class Controler {

	@Autowired
	private ProxyConnection pcon;

	public Controler() {
		
	}
	@GetMapping("/")
	public boolean pay() {

		int h=(int) (Math.random()*100);
		System.out.println(h);
		if((h%2)==1){
	        Runnable myThread = () -> pcon.payDone();
	        Thread run = new Thread(myThread);
	        run.start();
			return true;
		}
		
		return false;
	}

}

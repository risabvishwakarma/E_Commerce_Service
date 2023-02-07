package com.unitral.payment_service.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.unitral.payment_service.Proxy.ProxyConnection;

@RestController
@RequestMapping("/payment")
public class Controler {

	@Autowired
	private ProxyConnection pcon;

	public Controler() {

	}

	@GetMapping("/{RsMid}")
	public int pay(@PathVariable String RsMid) {
		String[] ar=RsMid.split(";");

		int h = (int) (Math.random() * 100);
		System.out.println(h+" "+ar[0]);
		
		if ((h % 2) == 1) {
			Runnable myThread = () -> 
			pcon.payDone(ar[0]+";"+"Payment Sucessful"+";"+"Payment Id "+h+"\n"+"for your order of Price"+ar[1]);
			Thread run = new Thread(myThread);
			run.start();
			//pcon.payDone(ar[0]+";"+"Payment Sucessful"+";"+"Payment Id "+h+"\n"+"for your order of Price"+ar[1]);
			return h;
		}

		return -1;
	}

	

}

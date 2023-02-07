package com.unitral.notification_service.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unitral.notification_service.service.Service_Interface;

@RestController
@RequestMapping("/notification")
public class Notification_Controler {
	
	@Autowired
	private Service_Interface si;
	
	
	@GetMapping("/payDone/{RsMid}")
	public boolean PaymentDone(@PathVariable String RsMid) {
		
		return si.sendMail(RsMid);
		
	
		
	}
	@GetMapping("/")
	public boolean test() {
		
		return true;
	
		
	}
	
	@GetMapping("/payFailed")
	public ResponseEntity<?> PaymentFailed() {
		
		return si.sendMail()?ResponseEntity.ok("Sucessfully Sent PaymentFailed"):(ResponseEntity<?>) ResponseEntity
				.internalServerError();
		
	}
	
	@GetMapping("/haveOrder")
	public ResponseEntity<?> HaveOrder() {
		
		return si.sendMail()?ResponseEntity.ok("Sucessfully Sent HaveOrder"):(ResponseEntity<?>) ResponseEntity
				.internalServerError();
		
	}
	
	@GetMapping("/haveNotOrder")
	public ResponseEntity<?> HaveNotOrder() {
		
		return si.sendMail()?ResponseEntity.ok("Sucessfully Sent HaveNotOrder"):(ResponseEntity<?>) ResponseEntity
				.internalServerError();
		
	}
	
	

	
	

}

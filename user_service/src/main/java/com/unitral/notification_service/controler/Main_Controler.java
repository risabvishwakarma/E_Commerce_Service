package com.unitral.notification_service.controler;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.unitral.notification_service.controler.service.Service_Inter;
import com.unitral.notification_service.dao.User;

@RestController
public class Main_Controler {
	@Autowired
	private Service_Inter service;

	public Main_Controler() {
		
	}
	
	@GetMapping("/")
	public List<User> getAllUser(){
		System.out.println("helo");
		
		return service.getAllUser();
		}
	
	
	@GetMapping("/{id}")
	public Optional<User> getUser(@RequestParam int id){
		
		return service.getUser(id);
	}
	
	
	@PutMapping("/")
	public User updateUser(@RequestBody User user){
		
		return service.updateUser(user);
	}
	
	
	@PostMapping("/")
	public User addUser(@RequestBody User user){
		
		return service.addUser(user);
	}
	
	
	@DeleteMapping("/{id}")
	public void deleteUser(@RequestParam int id){
		
		service.deleteUser(id);
	}

}

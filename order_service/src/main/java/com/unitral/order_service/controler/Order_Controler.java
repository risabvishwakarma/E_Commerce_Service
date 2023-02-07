package com.unitral.order_service.controler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.unitral.order_service.controler.repositories.ProxtyUser;
//import com.unitral.order_service.controler.repositories.ProxtyUser;
import com.unitral.order_service.controler.repositories.ProxyCatalogue;
import com.unitral.order_service.dao.CatalogueProduct;
import com.unitral.order_service.dao.Product;
import com.unitral.order_service.service.Service;

@RestController
@RequestMapping("/order")
public class Order_Controler {

	@Autowired
	private Service service;

	@GetMapping("/{ls}")
	public List<Product> getCat(@PathVariable String ls) {

		return service.getCat(Arrays.asList(ls.split(":")));

	}

	@GetMapping("/")
	public List<Product> getAll() {
		return service.getAll();
	}

	@PostMapping("/")
	public Product addProduct(@RequestBody Product newProduct) {
		return service.addProduct(newProduct);
	}

	@PutMapping("/")
	public Product updateProduct(@RequestBody Product newProduct) {
		return service.updateProduct(newProduct);
	}

	@DeleteMapping("/{deleteId}")
	public void deleteProduct(@PathVariable int deleteId) {
		service.deleteProduct(deleteId);
	}

	@GetMapping("/checkout/{userId}")
	String makePayment(@PathVariable int userId) {

		return service.checkoutWithUserId(userId);

	}

	

}

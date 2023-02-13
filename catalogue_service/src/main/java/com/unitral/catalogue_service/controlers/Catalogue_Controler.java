package com.unitral.catalogue_service.controlers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unitral.catalogue_service.dao.Products;
import com.unitral.catalogue_service.repository.ProxyInterface;
import com.unitral.catalogue_service.sevice.Service;

@RestController
@RequestMapping("/catalogue")
public class Catalogue_Controler {
	@Autowired
	private Service service;

	@Autowired
	private ProxyInterface pi;

	@GetMapping("/test")
	public List<Products> test_Products() {
		Map<Integer, Products> list = new HashMap<>();
		StringBuffer sb = new StringBuffer();
		service.getProducts().forEach(pro -> {
			System.out.println(pro.getId());
			list.put(pro.getId(), pro);
			sb.append(pro.getId());
			sb.append(":");

		});
		List<Products> productFromOrderService = pi.getOrderedProducts(sb.toString());

		for (Products p : productFromOrderService) {
			p.setProductQuantity(list.get(p.getId()).getProductQuantity());
			p.setUserId(list.get(p.getId()).getUserId());
			p.setMapId(list.get(p.getId()).getMapId());

		}
		return productFromOrderService;

	}

	@GetMapping("/")
	public List<Products> get_Products() {
		return service.getProducts();

	}

	@GetMapping("/{userId}")
	public Map<Integer, Integer> get_Products(@PathVariable String userId) {
		Map<Integer, Integer> mp = new HashMap<>();
		service.getProductsByUserId(userId).forEach(product -> {
			mp.put(product.getId(), product.getProductQuantity());

		});

		return mp;

	}

	@PostMapping("/")
	public Products Post_Products(@RequestBody Products newProduct

	) {
		return service.addProducts(newProduct);

	}

	@PutMapping("/")
	public Products Put_Products(@RequestBody Products newProduct) {
		return service.updateProducts(newProduct);

	}

	@DeleteMapping("/{id}")
	public void Delete_Products(@PathVariable String id) {

		service.deleteProducts(id);

	}
	@GetMapping("/delete/{userId}")
	public void deleteUserDetails(@PathVariable  int userId ){
		service.deleteByUser(userId);

	}

}

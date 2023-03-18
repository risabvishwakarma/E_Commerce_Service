package com.unitral.cart_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.unitral.cart_service.dao.Products;

public interface CartRepository extends JpaRepository<Products, String> {
	
	List<Products> findByUserId(String userId);

}

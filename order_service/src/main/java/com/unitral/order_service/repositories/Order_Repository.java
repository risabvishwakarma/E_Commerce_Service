package com.unitral.order_service.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.unitral.order_service.dao.Product;

public interface Order_Repository extends JpaRepository<Product, Integer> {

	Product findByProductNameAndSellerId(String productName, String sellerId);

}

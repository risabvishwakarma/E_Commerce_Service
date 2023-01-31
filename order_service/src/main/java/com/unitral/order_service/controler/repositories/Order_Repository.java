package com.unitral.order_service.controler.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unitral.order_service.dao.Product;

public interface Order_Repository extends JpaRepository<Product, String> {

}

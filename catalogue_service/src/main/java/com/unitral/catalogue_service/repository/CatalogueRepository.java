package com.unitral.catalogue_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unitral.catalogue_service.dao.Products;

public interface CatalogueRepository extends JpaRepository<Products, String> {
	
	List<Products> findByUserId(String userId);

}

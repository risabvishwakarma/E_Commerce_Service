package com.unitral.catalogue_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unitral.catalogue_service.dao.Products;
import org.springframework.data.jpa.repository.Query;

public interface CatalogueRepository extends JpaRepository<Products, String> {
	
	List<Products> findByUserId(String userId);

}

package com.unitral.catalogue_service.dao;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

@Entity

public class Products {
	
	@Id
	String mapId;
	@Nonnull
	private String productId;
	@Nonnull
	private String userId;
	private int productQuantity;
	
	Products(){}
	
	
	
	public Products(String userId, String productId,int productQuantity) {
		super();
		mapId=userId+productId;
		this.productId = productId;
		this.userId = userId;
		this.productQuantity = productQuantity;
	}
	
	
	public String getMapId() {
		return mapId;
	}
	public void setMapId(String mapId) {
		this.mapId = mapId;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getProductQuantity() {
		return productQuantity;
	}
	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}

	
	
	
	

	
}

package com.unitral.order_service.dao;

import jakarta.annotation.Nonnull;

public class CatalogueProduct {

	private int id;

	private String userId;
	private int productQuantity;
	public CatalogueProduct(int id, String userId, int productQuantity) {
		super();
		this.id = id;
		this.userId = userId;
		this.productQuantity = productQuantity;
	}



	public CatalogueProduct() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

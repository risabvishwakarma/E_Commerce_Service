package com.unitral.catalogue_service.dao;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity

public class Products {
	
	@Id
	@GeneratedValue
	
	private int productId;
	private String productName;
	private int productPrice;
	
	
	public Products(int productId, String productName, int productprice) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productprice;
	}
	
	public Products(String productName, int productprice) {
		this(0,productName,productprice);	
	}

	

	public Products() {
		
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductprice() {
		return productPrice;
	}

	public void setProductprice(int productprice) {
		this.productPrice = productprice;
	}

}

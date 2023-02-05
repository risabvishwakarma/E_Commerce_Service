package com.unitral.catalogue_service.dao;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
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
	
	@Transient
	private String productName;
	@Transient
	private int  productPrice;
	@Transient
	private int  productPriceoff;
	@Transient
	private String productCategory;			//Electric,Study,Other
 
	
	Products(){}
	
	
	
	public Products(String userId, String productId,int productQuantity) {
		super();
		mapId=userId+productId;
		this.productId = productId;
		this.userId = userId;
		this.productQuantity = productQuantity;
	}
	
	public Products(String mapId, String productId, String userId, int productQuantity, String productName,
			int productPrice, int productPriceoff, String productCategory) {
		super();
		this.mapId = mapId;
		this.productId = productId;
		this.userId = userId;
		this.productQuantity = productQuantity;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productPriceoff = productPriceoff;
		this.productCategory = productCategory;

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



	public String getProductName() {
		return productName;
	}



	public void setProductName(String productName) {
		this.productName = productName;
	}



	public int getProductPrice() {
		return productPrice;
	}



	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}



	public int getProductPriceoff() {
		return productPriceoff;
	}



	public void setProductPriceoff(int productPriceoff) {
		this.productPriceoff = productPriceoff;
	}



	public String getProductCategory() {
		return productCategory;
	}



	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}




	
	
	
	

	
}

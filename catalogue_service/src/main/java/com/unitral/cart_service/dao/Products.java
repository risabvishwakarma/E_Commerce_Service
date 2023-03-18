package com.unitral.cart_service.dao;

import jakarta.annotation.Nonnull;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name="Catalogue")
public class Products {
	
	@Id
	String mapId;
	
	@Nonnull
	private int id;

	@Nonnull
	private int userId;
	private int productQuantity;
	
	@Transient
	private String productName;
	@Transient
	private int  productPrice;
	@Transient
	private int  productPriceoff;
	@Transient
	private String productCategory;			//Electric,Study,Other
 
	
	public Products( int userId,int id, int productQuantity) {
		super();
		this.mapId=(""+userId + id).trim();
		this.id = id;
		this.userId = userId;
		this.productQuantity = productQuantity;

	}


	Products(){}


	public Products( int id, int userId, int productQuantity, String productName, int productPrice,
			int productPriceoff, String productCategory) {
		super();
		this.mapId=(""+userId + id).trim();
		this.id = id;
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


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
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

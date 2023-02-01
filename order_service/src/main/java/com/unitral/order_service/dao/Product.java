package com.unitral.order_service.dao;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Product {
	
	
	@GeneratedValue
	@Id
	private int id;
	@Nonnull
	private String productId;
	private String productName;
	private int  productPrice;
	private int  productPriceoff;
	private String productCategory;       //Electric,Study,Other
	private int productAvQuantity;        //product available quantity

	public Product() {
		
	}

	public Product(String productId, String productName, int productPrice, 
			int productAvQuantity,String productCategory,int  productPriceoff) {
		super();

		this.productPriceoff=productPriceoff;
		this.productCategory=productCategory;;
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productAvQuantity = productAvQuantity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
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

	public int getProductAvQuantity() {
		return productAvQuantity;
	}

	public void setProductAvQuantity(int productAvQuantity) {
		this.productAvQuantity = productAvQuantity;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public int getProductPriceoff() {
		return productPriceoff;
	}

	public void setProductPriceoff(int productPriceoff) {
		this.productPriceoff = productPriceoff;
	}

}

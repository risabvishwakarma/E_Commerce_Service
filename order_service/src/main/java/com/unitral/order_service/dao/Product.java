package com.unitral.order_service.dao;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Products")
public class Product {
	
	
	@GeneratedValue
	@Id
	@Column(name="productId")
	private int productId;
	@Nonnull
	private String sellerId;
	private String productName;
	private int  productPrice;
	private int  productPriceoff;
	private String productCategory;       //Electric,Study,Other
	private int productAvQuantity;        //product available quantity

	public Product() {
		
	}

	public Product(String sellerId, String productName, int productPrice, 
			int productAvQuantity,String productCategory,int  productPriceoff) {
		super();

		this.productPriceoff=productPriceoff;
		this.productCategory=productCategory;;
		this.sellerId = sellerId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productAvQuantity = productAvQuantity;
	}

	public int getId() {
		return productId;
	}

	public void setId(int id) {
		this.productId = id;
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

	public String getSellerId() {
		return sellerId;
	}

	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

}

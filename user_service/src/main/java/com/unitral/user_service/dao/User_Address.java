package com.unitral.user_service.dao;

import jakarta.annotation.Nonnull;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="User_Address")
public class User_Address {
	
	@Id
	@GeneratedValue
	private int add_id;
	
	private String userLocalAddress;
	private String landMark;
	@Nonnull
	private int PinCode;
	@Nonnull
	private String city;
	private String state;
	private String country;
	private String phoneNo;
	
//	@ManyToOne
//	private User user;

	public User_Address() {
		
	}
	public User_Address(int id, String userId, String userLocalAddress, String landMark, int pinCode, String city,
			String state, String country,String phoneNo) {
		super();
		this.phoneNo=phoneNo;
		this.add_id = id;
	
		this.userLocalAddress = userLocalAddress;
		this.landMark = landMark;
		PinCode = pinCode;
		this.city = city;
		this.state = state;
		this.country = country;
	}

	public int getId() {
		return add_id;
	}

	public void setId(int id) {
		this.add_id = id;
	}



	public String getUserLovalAddress() {
		return userLocalAddress;
	}

	public void setUserLovalAddress(String userLovalAddress) {
		this.userLocalAddress = userLovalAddress;
	}

	public String getLandMark() {
		return landMark;
	}

	public void setLandMark(String landMark) {
		this.landMark = landMark;
	}

	public int getPinCode() {
		return PinCode;
	}

	public void setPinCode(int pinCode) {
		PinCode = pinCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getUserLocalAddress() {
		return userLocalAddress;
	}
	public void setUserLocalAddress(String userLocalAddress) {
		this.userLocalAddress = userLocalAddress;
	}

}

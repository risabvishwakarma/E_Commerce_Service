package com.unitral.notification_service.dao;

import jakarta.persistence.*;


@Entity
@Table(name="Customers")
public class User {
	@Id
	 @GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int userId;
	private String UserName;
	
	private String UserMail;
	private String UserPhoneNo;
	private String UserRole;

	public User(String userName, String userMail, String userPhoneNo, String userRole) {
		super();
	
		UserName = userName;
		UserMail = userMail;
		UserPhoneNo = userPhoneNo;
		UserRole = userRole;
	}

	public User() {
		
	}

	public int getId() {
		return userId;
	}

	public void setId(int id) {
		this.userId = id;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getUserMain() {
		return UserMail;
	}

	public void setUserMain(String userMain) {
		UserMail = userMain;
	}

	public String getUserPhoneNo() {
		return UserPhoneNo;
	}

	public void setUserPhoneNo(String userPhoneNo) {
		UserPhoneNo = userPhoneNo;
	}

	public String getUserRole() {
		return UserRole;
	}

	public void setUserRole(String userRole) {
		UserRole = userRole;
	}

}

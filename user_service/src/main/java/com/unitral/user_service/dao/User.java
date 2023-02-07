package com.unitral.user_service.dao;

import java.util.ArrayList;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;


@Entity
@Table(name="Customers")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	
	
	private int userId;
	private String UserName;
	@Nonnull
	private String Password;
	@Nonnull
	private String UserMail;
	private String UserPhoneNo;
	private String UserRole;
	
//	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
//	private ArrayList<User_Address> UserAddressList=new ArrayList<>();

	public User(String userName, String userMail, String userPhoneNo, String userRole,String password) {
		super();
		Password=password;
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

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}



}

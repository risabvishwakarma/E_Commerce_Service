package com.unitral.user_service.controler.service;

import java.util.List;
import java.util.Optional;

import com.unitral.user_service.dao.User;

public interface Service_Inter {
	public List<User> getAllUser();
	Optional<User> getUser(int id);
	User addUser(User user);
	void deleteUser(int id);
	User updateUser(User user);
	public boolean isUserPresent(int userId);

}

package com.unitral.user_service.controler.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unitral.user_service.dao.User;
import com.unitral.user_service.repository.UserRepository;

@Service
public class Service_Imp implements Service_Inter {
	boolean f = true;

	@Autowired
	private UserRepository urepo;

	public Service_Imp() {

	}

	@Override
	public List<User> getAllUser() {
		if (f) {
			f();
			f = false;
		}

		return urepo.findAll();
	}

	@Override
	public Optional<User> getUser(int id) {

		return urepo.findById(id);
	}

	@Override
	public User addUser(User user) {

		return urepo.save(user);
	}

	@Override
	public User updateUser(User user) {

		return urepo.findById(user.getId()).map(dbUser -> {

			return urepo.save(dbUser);
		}).orElse(urepo.save(user));

	}

	@Override
	public void deleteUser(int id) {
		urepo.deleteById(id);

	}

	void f() {
//		urepo.save(new User("Risab","risab.7088@gmail.com","6398422422","customer","Risab@123"));
//		urepo.save(new User("Arya","aryasharma9634@gmail.com","69237494020","customer","Arya@123"));
//		urepo.save(new User("Deepu","deepu@gmail.com","69237494020","seller","Deepu@123"));
	}

	@Override
	public String isUserPresent(int id) {

		Optional<User> user = urepo.findById(id);
		if (user.isEmpty())
			return "NO";
		return user.get().getUserMain(); // mail
	}

}

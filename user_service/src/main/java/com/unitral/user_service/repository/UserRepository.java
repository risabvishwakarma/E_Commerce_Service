package com.unitral.user_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unitral.user_service.dao.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}

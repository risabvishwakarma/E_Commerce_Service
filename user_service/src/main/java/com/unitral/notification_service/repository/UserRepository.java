package com.unitral.notification_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unitral.notification_service.dao.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}

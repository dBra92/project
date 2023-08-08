package com.prfs.hruser.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prfs.hruser.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByEmail(String email);
}

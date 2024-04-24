package com.fyp.groot.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fyp.groot.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	//User findByUsernameAndPassword(String username, String password);
	Optional<User> findByFirebaseId(String firebaseId);

}

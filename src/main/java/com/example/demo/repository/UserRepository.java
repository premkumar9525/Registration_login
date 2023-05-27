package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	boolean existsByemail(String email);

	boolean existsByusername(String username);

	boolean existsByPassword(String password);
	
	boolean existsByUsername(String username);


	Optional<User> findByfirstname(String firstname);






}

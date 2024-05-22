package com.example.myapp;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<AdministratorUser, Integer> {
	Optional<AdministratorUser> findByEmail(String email);
	List<AdministratorUser> findByPassword(String password);	

}

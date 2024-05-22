package com.example.myapp;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
	public interface OtherUserRepository extends JpaRepository<OtherUsers, Integer> {
		Optional<AdministratorUser> findByEmail(String email);
		List<AdministratorUser> findByPassword(String password);	

	}

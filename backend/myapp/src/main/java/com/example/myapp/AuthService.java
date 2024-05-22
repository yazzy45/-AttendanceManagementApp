package com.example.myapp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class AuthService {
	
	@Autowired
	private final UserRepository userRepository;
	public AuthService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public boolean authenticate(String email, String password) {
		Optional<AdministratorUser> user = userRepository.findByEmail(email);
	    System.out.println(user.isPresent());
		if (user.isPresent()) {
            AdministratorUser user1 = userRepository.findByEmail(email).get();
            return user1.getPassword().equals(password);
        }
		return false;
	}

}

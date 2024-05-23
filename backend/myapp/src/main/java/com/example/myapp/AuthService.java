package com.example.myapp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class AuthService {
	
	@Autowired
	private final UserRepository userRepository;
	private final OtherUserRepository otherUserRepository;
	
	public AuthService(UserRepository userRepository , OtherUserRepository otherUserRepository) {
		this.userRepository = userRepository;
		this.otherUserRepository = otherUserRepository;
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
	
	
	
	public List<OtherUsers> findOtherUserAll() {
                  return otherUserRepository.findAll();
    }

}

package com.example.myapp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class Mycomandrunnner implements CommandLineRunner{

	
	@Autowired
	private UserRepository userRepository;
	@Override
	public void run(String... args) throws Exception {
		AdministratorUser user = new AdministratorUser("a@a", "aa");
		AdministratorUser user2 = new AdministratorUser("b@b","bb");
		userRepository.save(user);
		userRepository.save(user2);
		Optional<AdministratorUser> uSer = userRepository.findByEmail("a@a");
		System.out.println(uSer.get().getPassword());
		     
		
	}

}

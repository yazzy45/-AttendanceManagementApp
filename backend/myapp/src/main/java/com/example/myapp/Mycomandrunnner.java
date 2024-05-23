package com.example.myapp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class Mycomandrunnner implements CommandLineRunner{

	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OtherUserRepository otherUserRepository;
	@Override
	public void run(String... args) throws Exception {
		AdministratorUser user1 = new AdministratorUser("a@a", "aa");
		AdministratorUser user2 = new AdministratorUser("b@b","bb");
		userRepository.save(user1);
		userRepository.save(user2);
		
		 List<OtherUsers> otherUsersList = new ArrayList<>();
	        otherUsersList.add(new OtherUsers( "Yazzy", "a@a.com", "aaa", "エンジニア"));
	        otherUsersList.add(new OtherUsers("Bob", "b@b.com", "bbb", "デザイナー"));
	        otherUsersList.add(new OtherUsers( "Charlie", "c@c.com", "ccc", "マネージャー"));
	        otherUsersList.add(new OtherUsers( "David", "d@d.com", "ddd", "エンジニア"));
	        otherUsersList.add(new OtherUsers( "Eve", "e@e.com", "eee", "アナリスト"));
	        otherUsersList.add(new OtherUsers( "Frank", "f@f.com", "fff", "エンジニア"));
	        otherUsersList.add(new OtherUsers( "Grace", "g@g.com", "ggg", "デザイナー"));
	        otherUsersList.add(new OtherUsers( "Heidi", "h@h.com", "hhh", "マネージャー"));
	        otherUsersList.add(new OtherUsers( "Ivan", "i@i.com", "iii", "エンジニア"));
	        otherUsersList.add(new OtherUsers( "Judy", "j@j.com", "jjj", "アナリスト"));

	        otherUserRepository.saveAll(otherUsersList);
        
		
	}

}

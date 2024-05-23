package com.example.myapp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//jsonを返すためのRestController
@RestController
@RequestMapping("/api") // クラスレベルのプレフィックス
public class MyRestController {
	
	@Autowired
	private AuthService authService;
	
	@Autowired
	private UserRepository userRepository;

	
	@PostMapping("/facerecognition")
	public String FaceRecognition(@RequestBody  String data) {
		System.out.println(data);
//		認識した名前をうけとる
		
        return "顔認証しました";      
    }
	
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/login")
	public ResponseEntity<Map<String, String>> Login(@RequestBody  LoginRequest loginRequest) {
        System.out.println(loginRequest.getEmail());
        System.out.println(loginRequest.getPassword());
        Map<String, String> response = new HashMap<>();
		if (authService.authenticate(loginRequest.getEmail(), loginRequest.getPassword())) {
			response.put("status", "success");
			return ResponseEntity.ok(response);
		}
		response.put("status", "error");
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/home")
	public List<OtherUsers> getUsersByAdminId() {
		AdministratorUser user = userRepository.findByEmail("a@a").get();
		System.out.println( authService.findOtherUserAll());
		return authService.findOtherUserAll();
      
    }
	

}


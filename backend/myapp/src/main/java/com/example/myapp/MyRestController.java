package com.example.myapp;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//jsonを返すためのRestController
@RestController
public class MyRestController {
	
	@PostMapping("/facerecognition")
	public String FaceRecognition(@RequestBody  String data) {
		System.out.println(data);
//		認識した名前をうけとる
		
        return "顔認証しました";      
    }

}


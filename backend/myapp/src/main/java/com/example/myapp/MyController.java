package com.example.myapp;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {
	
	
	
	
	@GetMapping("/")
	public String home() {
//		ProcessBuilderとは、Javaから外部プログラムを実行するために使用するクラス。
		System.out.println("test");
		String scriptPath = "C:\\Users\\taiki.yasuda\\Desktop\\kensyu\\-AttendanceManagementApp\\python\\myapp\\src\\test2.py";
        File file = new File(scriptPath);
        if (!file.exists()) {
            System.out.println("Error: Python script file not found at " + scriptPath);
            return "index";
        }
		 try {
			ProcessBuilder pb = new ProcessBuilder("C:\\Users\\taiki.yasuda\\AppData\\Local\\Programs\\Python\\Python312\\python.exe", scriptPath);
			pb.redirectErrorStream(true);
			System.out.println(pb);
				 // プロセスを開始
			Process process = pb.start();
			
			// プロセスが終了するまで待機
			 int exitCode = process.waitFor();
			 
			 if (exitCode == 0) {
                 System.out.println("正常終了");
             } else {
                 System.out.println("異常終了"+exitCode);
                 
             }
			
			System.out.println("test2");
		} 	 
		 catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}	 
		return "index";
	}
	


}

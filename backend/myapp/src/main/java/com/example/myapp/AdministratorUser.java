package com.example.myapp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@Entity
public class AdministratorUser {
	
	
	public AdministratorUser(String name, int age, String password) {
		this.name = name;
		this.password = password;
	}
	
	@Id
	@GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
	@Column
	private int id;
	
	@NotBlank(message = "名前が必要です")
	@Size(min = 2, max = 20, message = "名前は2文字以上20文字以下です")
	private String name;
	
	@NotBlank(message = "パスワードが必要です")
	@Size(min = 2, max = 20, message = "パスワードは2文字以上20文字以下です")
	private String password;

}

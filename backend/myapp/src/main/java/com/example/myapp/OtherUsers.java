package com.example.myapp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class OtherUsers {
	

	public OtherUsers ( String username, String email, String password, String role) {
		
		this.email = email;
		this.password = password;
		this.username = username;
		this.role = role;
	}

	@Id
	@GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
	@Column
	private int id;
	
	
	@NotBlank(message = "メールアドレスが必要です")
	@Email(message = "メールアドレスの形式が正しくありません")
	private String email;
	
	@NotBlank(message = "パスワードが必要です")
	@Size(min = 2, max = 20, message = "パスワードは2文字以上20文字以下です")
	private String password;
	
	@NotBlank(message = "ユーザ名が必要です")
	@Size(min = 2, max = 20, message = "ユーザ名は2文字以上20文字以下です")
	private String username;
		
	@NotBlank(message = "ロールが必要です")
	@Size(min = 2, max = 20, message = "ロールは2文字以上20文字以下です")
	private String role;
	
	@Override
    public String toString() {
        return "OtherUsers";
    }
}

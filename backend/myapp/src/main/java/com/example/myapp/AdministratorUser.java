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
public class AdministratorUser {
	

	public AdministratorUser(String email, String password) {
		this.email = email;
		this.password = password;
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
	
	
	@Override
    public String toString() {
        return "OtherUsers{id=" + id +  "', email='" + email  + "'}";
    }

}

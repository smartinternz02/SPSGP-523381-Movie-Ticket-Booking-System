package com.movie3.movie3.entity;

import jakarta.persistence.*;

@Entity
@Table(name="admin")
public class admin {
	
	@Id
	@Column(name="username")
	private String Username;
	@Column(name="password")
	private String Password;
	public admin() {}
	public admin(String username, String password) {
		super();
		Username = username;
		Password = password;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	
	
}

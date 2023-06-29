package com.movie3.movie3.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="user")
public class user {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	@Column(name="username")
	private String username;
	@Column(name="password")
	private String password;
	@Column(name="email")
	private String email;
	@Column(name="phoneno")
	private Long phno;
	public user() {}
	public user(Long id, String username, String password,String email,Long phno) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email=email;
		this.phno=phno;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setEmail(String email)
	{
		this.email=email;
	}
	public String getEmail()
	{
		return email;
	}
	public void setPhno(Long phno)
	{
		this.phno=phno;
	}
	public Long getPhno()
	{
		return phno;
	}
	
}

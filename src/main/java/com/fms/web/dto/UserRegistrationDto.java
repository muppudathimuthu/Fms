package com.fms.web.dto;

public class UserRegistrationDto {
	private String username;
	private String password;
	private long phoneno;
	private String email;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public UserRegistrationDto() {
		
	}
	public UserRegistrationDto(String username, String password, long phoneno, String email) {
		super();
		this.username = username;
		this.password = password;
		this.phoneno = phoneno;
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public long getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(long phoneno) {
		this.phoneno = phoneno;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}

package com.jweb.beans;

public class UserBean {
	private String email;
	private String password;
	private String name;
	private Boolean admin;
	
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmail() {
		return email;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassword() {
		return password;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	
	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}
	public Boolean getAdmin() {
		return admin;
	}
}

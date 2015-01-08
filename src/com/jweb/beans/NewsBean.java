package com.jweb.beans;

public class NewsBean {
	private Long id;
	private String content;
	private String userEmail;
	private String date;
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String mail) {
		this.userEmail = mail;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	public String getDate() {
		return date;
	}
}

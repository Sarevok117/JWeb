package com.jweb.beans;

public class NewsBean {
	private Long id;
	private String email;
	private String name;
	private String news;
	private String date;

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmail() {
		return email;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}

	public void setNews(String news) {
		this.news = news;
	}
	public String getNews() {
		return news;
	}

	public void setDate(String date) {
		this.name = date;
	}
	public String getDate() {
		return date;
	}
}

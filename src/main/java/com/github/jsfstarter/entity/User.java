package com.github.jsfstarter.entity;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class User {
	private String username;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}

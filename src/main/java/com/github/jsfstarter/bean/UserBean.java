package com.github.jsfstarter.bean;

import java.io.Serializable;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

@Named
@SessionScoped
public class UserBean implements Serializable {
	private static final long serialVersionUID = 7597128582555596302L;
	
	private String currentUsername;
	private String currentId;
	private boolean loggedIn;
	
	public String getCurrentUsername() {
		return currentUsername;
	}
	
	public void setCurrentUsername(String currentUsername) {
		this.currentUsername = currentUsername;
	}
	
	public String getCurrentId() {
		return currentId;
	}
	
	public void setCurrentId(String currentId) {
		this.currentId = currentId;
	}
	
	public boolean isLoggedIn() {
		return loggedIn;
	}
	
	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}
}

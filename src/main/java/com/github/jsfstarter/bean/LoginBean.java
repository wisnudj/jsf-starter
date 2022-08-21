package com.github.jsfstarter.bean;

import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@RequestScoped
public class LoginBean {
	@Inject
	UserBean user;
	
	private String username;
	private String password;
	
	@PostConstruct
	public void postConstruct() {
		if(user.isLoggedIn()) Faces.redirect("index.xhtml");
	}
	
	public void submit() {
		if(username.equalsIgnoreCase(password)) {
			user.setCurrentId("td001");
			user.setCurrentUsername(username);
			user.setLoggedIn(true);
			
			Faces.redirect("index.xhtml");
		}
		else {
			System.out.println("gagal login");			
			Messages.add(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Failed login", "Wrong username or password"));
		}
	}

	public UserBean getUser() {
		return user;
	}

	public void setUser(UserBean user) {
		this.user = user;
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
}

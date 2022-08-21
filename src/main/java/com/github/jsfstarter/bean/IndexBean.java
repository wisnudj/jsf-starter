package com.github.jsfstarter.bean;

import java.io.Serializable;

import org.omnifaces.cdi.ViewScoped;
import org.omnifaces.util.Faces;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@ViewScoped
public class IndexBean implements Serializable {
	@Inject
	UserBean user;
	
	private String nama;
	
	@PostConstruct
	public void postConstuct() {
		if(!user.isLoggedIn()) Faces.redirect("public/login.xhtml");
	}

	public UserBean getUser() {
		return user;
	}

	public void setUser(UserBean user) {
		this.user = user;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}
}

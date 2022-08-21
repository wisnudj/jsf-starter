package com.github.jsfstarter.bean;

import org.omnifaces.util.Faces;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@Named
@RequestScoped
public class LogoutBean {
	public void submit() {
		Faces.getSession().invalidate();
		Faces.redirect("public/login.xhtml");
	}
}

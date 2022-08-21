package com.github.jsfstarter.filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@WebFilter(filterName = "AuthFilter", urlPatterns = { "*.xhtml" })
public class AuthorizationFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
//		HttpServletRequest reqt = (HttpServletRequest) request;
//		HttpSession ses = reqt.getSession(false);
//		
//		if(ses == null) {
//			System.out.println("null");
//		}
//		else {
//			System.out.println("ada isi");
//			ses.getAttributeNames().asIterator().forEachRemaining(el -> {
//				System.out.println(el);
//			});
//			
//			System.out.println(ses.getAttribute("currentUser"));
//		}
		
		chain.doFilter(request, response);
	}
}

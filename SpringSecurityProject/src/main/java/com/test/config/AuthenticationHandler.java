package com.test.config;

import java.io.IOException;
import java.util.Set;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Service;
import org.thymeleaf.extras.springsecurity6.auth.AuthUtils;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class AuthenticationHandler implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		// TODO Auto-generated method stub
		Set<String> authorityListToSet = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
		
		if(authorityListToSet.contains("ROLE_ADMIN"))
		{
			response.sendRedirect("/voterslisting");
		}
		else
		{
			response.sendRedirect("/VotePage");
		}
		
	}

}

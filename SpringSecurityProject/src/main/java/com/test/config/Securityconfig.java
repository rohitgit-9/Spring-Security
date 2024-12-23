package com.test.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.test.service.CustomUserDetailsService;

import ch.qos.logback.core.joran.spi.HttpUtil.RequestMethod;

@Configuration
@EnableWebSecurity
public class Securityconfig {

	@Autowired
	AuthenticationHandler success;

	@Bean
	public SecurityFilterChain filters(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeHttpRequests().requestMatchers(HttpMethod.POST, "/save**").permitAll()
				.requestMatchers("/voterslisting**").hasRole("ADMIN").requestMatchers("/VotePage**").hasRole("USER")
				.requestMatchers("/signin**").permitAll().requestMatchers("/register**").permitAll().anyRequest()
				.authenticated().and().formLogin().loginPage("/usershome").loginProcessingUrl("/doprocess")
				.successHandler(success).permitAll();
		return http.build();

	}

	@Bean
	public BCryptPasswordEncoder passwordencoder() {
		return new BCryptPasswordEncoder(12);
	}

	@Bean
	public UserDetailsService userDetailsService() {
		return new CustomUserDetailsService();
	}

	@Bean
	public DaoAuthenticationProvider daoprovider() {
		DaoAuthenticationProvider dao = new DaoAuthenticationProvider();
		dao.setPasswordEncoder(passwordencoder());
		dao.setUserDetailsService(userDetailsService());
		return dao;
	}

}

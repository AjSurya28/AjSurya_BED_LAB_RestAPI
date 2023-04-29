package com.gl.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

@Configuration
public class WebSecurityConfig extends AbstractSecurityWebApplicationInitializer{

	@Bean
	public UserDetailsService userDetailsService() {
		return new  UserDetailsServiceImpl ();
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
	DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
	authProvider.setUserDetailsService((org.springframework.security.core.userdetails.UserDetailsService) userDetailsService());
	authProvider.setPasswordEncoder(passwordEncoder());
	return authProvider;
	}

	@Autowired
	protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	auth.authenticationProvider(authenticationProvider());

}
	protected void configure(HttpSecurity http) throws Exception{
		http.authorizeHttpRequests()
		.requestMatchers("/","/student/save","/student/showFormForAdd", "/student/403").hasAnyAuthority("USER","ADMIN")
		.requestMatchers("/student/showForUpdate","/student/delete").hasAuthority("ADMIN")

		.anyRequest().authenticated()
		.and()
		.formLogin().loginProcessingUrl("/login").successForwardUrl("/student/list").permitAll()
		.and()
		.logout().logoutSuccessUrl("/login").permitAll()
		.and()
		.exceptionHandling().accessDeniedPage("/student/403")
		.and()
		.cors().and().csrf().disable();
		
	}
		
	}

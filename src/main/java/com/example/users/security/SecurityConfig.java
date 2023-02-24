package com.example.users.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;



@EnableWebSecurity
public class SecurityConfig  {
	@Autowired
	UserDetailsService userDetailsService;
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	AuthenticationManager authMgr;
	
	/*@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService)
		.passwordEncoder(bCryptPasswordEncoder);
	}*/
	
	@Bean
	public AuthenticationManager authManager(HttpSecurity http, BCryptPasswordEncoder bCryptPasswordEncoder,
			UserDetailsService userDetailsService) throws Exception {
		return http.getSharedObject(AuthenticationManagerBuilder.class).userDetailsService(userDetailsService)
				.passwordEncoder(bCryptPasswordEncoder).and().build();
	}

	
	//	protected void configure(HttpSecurity http) throws Exception {
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws
	Exception {
		http.csrf().disable();
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
		//consulter tous les produits
		http.authorizeRequests().antMatchers("/api/**").hasAnyAuthority("ADMIN","USER");
		//http.authorizeRequests().antMatchers("/airline/**").hasAnyAuthority("ADMIN","USER");
		http.authorizeRequests().antMatchers("/airline/**").permitAll();
		http.authorizeRequests().antMatchers("/notif/**").permitAll();
		http.authorizeRequests().antMatchers("/review/**").permitAll();
		http.authorizeRequests().antMatchers("/new/**").permitAll();
		http.authorizeRequests().antMatchers("/replay/**").permitAll();
		http.authorizeRequests().antMatchers("/coupon/**").permitAll();
		http.authorizeRequests().antMatchers("/activity/**").permitAll();
		http.authorizeRequests().antMatchers("/stat/**").permitAll();
		http.authorizeRequests().antMatchers("/reservation/**").permitAll();
		http.authorizeRequests().antMatchers("/vol/**").permitAll();
		http.authorizeRequests().antMatchers("/hotel/**").permitAll();
		http.authorizeRequests().antMatchers("/tour/**").permitAll();
		http.authorizeRequests().antMatchers("/booking/airline/all/**").permitAll();
		http.authorizeRequests().antMatchers("/airline/all/**").permitAll();
		http.authorizeRequests().antMatchers("/api/**").permitAll();
		http.authorizeRequests().antMatchers("/booking/login/**").permitAll();
		http.authorizeRequests().antMatchers("/booking/api/**").permitAll();
		http.authorizeRequests().antMatchers("/booking/**").permitAll();
		http.authorizeRequests().antMatchers("/stat/get**").permitAll();
		
		
		//consulter un produit par son id
		http.authorizeRequests().antMatchers(HttpMethod.GET,"/api/**").hasAnyAuthority("ADMIN","USER");
		//ajouter un nouveau produit
		http.authorizeRequests().antMatchers(HttpMethod.POST,"/api/**").hasAuthority("ADMIN");
		//modifier un produit
		http.authorizeRequests().antMatchers(HttpMethod.PUT,"/api/**").hasAuthority("ADMIN");
		//supprimer un produit
		http.authorizeRequests().antMatchers(HttpMethod.DELETE,"/api/**").hasAuthority("ADMIN");
		
		http.authorizeRequests().antMatchers("/login").permitAll();
		
		http.authorizeRequests().antMatchers("/register").permitAll();
		http.authorizeRequests().antMatchers("/all").hasAuthority("ADMIN");
		http.authorizeRequests().anyRequest().authenticated();
		
		http.addFilter(new JWTAuthenticationFilter (authMgr)) ; 
		//http.addFilter(new JWTAuthenticationFilter(authenticationManager()));
		//http.addFilter(new JWTAuthenticationFilter(authenticationManager()));
		http.addFilterBefore(new JWTAuthorizationFilter(),UsernamePasswordAuthenticationFilter.class);
		return http.build();
		
	}
}
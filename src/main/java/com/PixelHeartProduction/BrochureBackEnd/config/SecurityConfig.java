package com.PixelHeartProduction.BrochureBackEnd.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.PixelHeartProduction.BrochureBackEnd.service.CustomUserDetailsService;
import com.PixelHeartProduction.BrochureBackEnd.service.JwtFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private  JwtFilter jwtFilter;

	@Autowired
	private CustomUserDetailsService userDetailsService;
	
	@Override
	protected void configure (AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(userDetailsService);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.csrf().disable().authorizeRequests()
		.antMatchers("/login").permitAll()
		.antMatchers("/api/v1/register").permitAll()
		.antMatchers("/api/v1/message/send").permitAll()
		.antMatchers("/api/v1/visitor/visit").permitAll()
		.anyRequest().authenticated()
		.and().exceptionHandling().and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.addFilterBefore(jwtFilter,UsernamePasswordAuthenticationFilter.class).exceptionHandling();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder(){
		return NoOpPasswordEncoder.getInstance();
	}
	
	@Bean(name=BeanIds.AUTHENTICATION_MANAGER)
	@Override 
	public AuthenticationManager authenticationManagerBean() throws Exception{
		return super.authenticationManagerBean();
	}
}

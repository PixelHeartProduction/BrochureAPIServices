package com.PixelHeartProduction.BrochureBackEnd.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.PixelHeartProduction.BrochureBackEnd.dto.AuthenticatedUser;
import com.PixelHeartProduction.BrochureBackEnd.dto.JwtResponse;
import com.PixelHeartProduction.BrochureBackEnd.util.JwtUtil;

@Service
public class JwtValidationService {
	
	@Autowired
	private JwtResponse jwtResponse;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private CustomUserDetailsService userDetailsService;
	
	public ResponseEntity<?> validate(AuthenticatedUser authenticatedUser) {
		UserDetails userDetails = userDetailsService.loadUserByUsername(authenticatedUser.getUsername());
		Date date = new Date(); 
		jwtResponse.setDate(date);
		jwtResponse.setJwt(authenticatedUser.getJwt());
		try{
			jwtUtil.validateToken(authenticatedUser.getJwt(), userDetails);
			jwtResponse.setMessage("token is still valid");
			return new ResponseEntity<JwtResponse>(jwtResponse,HttpStatus.OK);
		} catch (Exception e) {
			jwtResponse.setMessage("token is expired or invalid");
			return new ResponseEntity<JwtResponse>(jwtResponse,HttpStatus.FORBIDDEN);
		}
	}
}

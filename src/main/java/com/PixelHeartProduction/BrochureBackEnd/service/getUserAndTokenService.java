package com.PixelHeartProduction.BrochureBackEnd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Component;

import com.PixelHeartProduction.BrochureBackEnd.dto.AuthenticatedUser;
import com.PixelHeartProduction.BrochureBackEnd.model.AuthRequest;
import com.PixelHeartProduction.BrochureBackEnd.model.User;
import com.PixelHeartProduction.BrochureBackEnd.repository.UserRepository;
import com.PixelHeartProduction.BrochureBackEnd.util.JwtUtil;

@Component
public class getUserAndTokenService {
	
	@Autowired
	private AuthenticatedUser response;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserRepository userRepository;

	public AuthenticatedUser setAuthUser(AuthRequest authRequest) throws Exception{
		try {
			authenticationManager.authenticate(
			new UsernamePasswordAuthenticationToken(authRequest.getUsername(),authRequest.getPassword())
			);
			User user = userRepository.findByUsername(authRequest.getUsername());
			response.setId(user.getId());
			response.setUsername(user.getUsername());
			response.setJwt(jwtUtil.generateToken(authRequest.getUsername()));
			
	}catch (Exception ex) {
		throw new Exception("invalid username/password");
	}
		return response;
	}
}

package com.PixelHeartProduction.BrochureBackEnd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.PixelHeartProduction.BrochureBackEnd.dto.AuthenticatedUser;
import com.PixelHeartProduction.BrochureBackEnd.model.AuthRequest;
import com.PixelHeartProduction.BrochureBackEnd.service.JwtValidationService;
import com.PixelHeartProduction.BrochureBackEnd.service.getUserAndTokenService;

@RestController
public class Authentication {
	
		@Autowired
		private JwtValidationService jwtValidationService;
	
		@Autowired
		private getUserAndTokenService getUserAndTokenService;
		
		
		//check if the user still has valid token
		@PostMapping("/authenticate")
		public ResponseEntity<?> authenticateJwt(@RequestBody AuthenticatedUser authenticatedUser) {
			return jwtValidationService.validate(authenticatedUser);
			
		}
		
		//login user from database and 
		@PostMapping("/login")
		public ResponseEntity<?> generateToken(@RequestBody AuthRequest authRequest) throws Exception {
			try {
				return new ResponseEntity<AuthenticatedUser>(getUserAndTokenService.setAuthUser(authRequest),HttpStatus.OK);
			} catch(Exception e) {
				return new ResponseEntity<String>(e.getMessage(),HttpStatus.FORBIDDEN);
			}
		}
}

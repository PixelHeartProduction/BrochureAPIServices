package com.PixelHeartProduction.BrochureBackEnd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.PixelHeartProduction.BrochureBackEnd.dto.AuthenticatedUser;
import com.PixelHeartProduction.BrochureBackEnd.model.AuthRequest;
import com.PixelHeartProduction.BrochureBackEnd.service.getUserAndTokenService;

@RestController
public class Authentication {
	
		@Autowired
		private getUserAndTokenService getUserAndTokenService;
		
		
		@PostMapping("/login")
		public AuthenticatedUser generateToken(@RequestBody AuthRequest authRequest) throws Exception {
			
			 getUserAndTokenService.setAuthUser(authRequest);
			return getUserAndTokenService.setAuthUser(authRequest);
		}
}

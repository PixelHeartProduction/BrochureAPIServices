package com.pixelHeartProduction.APIServices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pixelHeartProduction.APIServices.model.User;
import com.pixelHeartProduction.APIServices.repository.UserRepository;

@RestController
@RequestMapping("api/v1")
public class UserController {
	
		@Autowired
		private UserRepository userRepository;
		
		@PostMapping("/user")
		private User registerUser(@RequestBody User user) {
			return userRepository.save(user);
		}
		
}

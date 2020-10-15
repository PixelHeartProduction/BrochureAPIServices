package com.PixelHeartProduction.BrochureBackEnd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.PixelHeartProduction.BrochureBackEnd.model.User;
import com.PixelHeartProduction.BrochureBackEnd.repository.UserRepository;

@RestController
@RequestMapping("api/v1/")
public class UserContoller {

		@Autowired
		private UserRepository userRepository;
	
		//register a user
		@PostMapping("/register")
		public User registerUser(@RequestBody User user) {
			return userRepository.save(user);
		}
		
		@GetMapping("/test")
		public String sayHello() throws Exception{
			return "hello";
		}
		
		//get all user
		@GetMapping("/user")
		public List<User> getAllUser() throws Exception{
			return userRepository.findAll();
		}
		
		//delete user by id
		@DeleteMapping("/user")
		public User deleteUserById(@RequestParam(name="id") long id) {
			return userRepository.deleteById(id);
		}
}

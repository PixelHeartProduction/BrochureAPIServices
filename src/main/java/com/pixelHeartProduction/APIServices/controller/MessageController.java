package com.pixelHeartProduction.APIServices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pixelHeartProduction.APIServices.model.Message;
import com.pixelHeartProduction.APIServices.repository.MessageRepository;

@RestController
@RequestMapping("api/v1/")
public class MessageController {
	
	@Autowired
	private MessageRepository messageRepository;
	
	//get all messages
	@GetMapping("/message")
	public List<Message> getAllMessages(){
		return messageRepository.findAll();
	}
	
	// create message with body
	@PostMapping("/message")
	public Message createMessage(@RequestBody Message message){
		return messageRepository.save(message);
	}
}

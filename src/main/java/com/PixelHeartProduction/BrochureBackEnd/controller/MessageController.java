package com.PixelHeartProduction.BrochureBackEnd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.PixelHeartProduction.BrochureBackEnd.model.Message;
import com.PixelHeartProduction.BrochureBackEnd.repository.MessageRepository;

@RestController
@RequestMapping("api/v1")
public class MessageController {

	@Autowired
	private MessageRepository messageRepository;
	
	//get All message
	@GetMapping("/message")
	public List<Message> getAllMessage(){
		return messageRepository.findAll();
	}
	
	//send message
	@PostMapping("/message/send")
	public Message saveMessage(@RequestBody Message message) {
		return messageRepository.save(message);
	}
	
}

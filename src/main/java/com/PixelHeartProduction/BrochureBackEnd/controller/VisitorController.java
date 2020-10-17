package com.PixelHeartProduction.BrochureBackEnd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.PixelHeartProduction.BrochureBackEnd.model.Visitor;
import com.PixelHeartProduction.BrochureBackEnd.repository.VisitorRepository;

@RestController
@RequestMapping("api/v1")
public class VisitorController {
	
	@Autowired
	private VisitorRepository visitorRepository;
	
	//add a new visitor
	@PostMapping("/visitor/visit")
	public Visitor addVisitor(@RequestBody Visitor visitor) {
		return visitorRepository.save(visitor);
	}
	
	//get all visitor
	@GetMapping("/visitor")
	public List<Visitor> getAllVisitor(){
		return visitorRepository.findAll();
	}
}

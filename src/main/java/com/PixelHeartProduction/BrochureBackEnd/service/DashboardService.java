package com.PixelHeartProduction.BrochureBackEnd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PixelHeartProduction.BrochureBackEnd.dto.DashboardData;
import com.PixelHeartProduction.BrochureBackEnd.repository.MessageRepository;
import com.PixelHeartProduction.BrochureBackEnd.repository.VisitorRepository;

@Service
public class DashboardService {
	
	@Autowired
	private MessageRepository messageRepository;
	@Autowired
	private VisitorRepository visitorRepository;
	@Autowired
	private DashboardData dashboardData;
	
	public DashboardData getData() {
		dashboardData.setVisitors(visitorRepository.findAll());
		dashboardData.setMessages(messageRepository.findAll());
		return dashboardData;
	}
}

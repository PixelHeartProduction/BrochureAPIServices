package com.PixelHeartProduction.BrochureBackEnd.dto;

import java.util.List;

import org.springframework.stereotype.Component;

import com.PixelHeartProduction.BrochureBackEnd.model.Message;
import com.PixelHeartProduction.BrochureBackEnd.model.Visitor;

@Component
public class DashboardData {
	
	private List<Visitor> visitors;
	private List<Message> messages;
	
	public DashboardData() {}
	
	public DashboardData(List<Visitor> visitors, List<Message> messages) {
		super();
		this.visitors = visitors;
		this.messages = messages;
	}
	public List<Visitor> getVisitors() {
		return visitors;
	}
	public void setVisitors(List<Visitor> visitors) {
		this.visitors = visitors;
	}
	public List<Message> getMessages() {
		return messages;
	}
	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}
	
}

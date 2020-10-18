package com.PixelHeartProduction.BrochureBackEnd.dto;

import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class JwtResponse {
	
	private String message;
	private Date date;
	private String jwt;
	
	public JwtResponse() {}
	
	public JwtResponse(String message, Date date, String jwt) {
		super();
		this.message = message;
		this.date = date;
		this.jwt = jwt;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getJwt() {
		return jwt;
	}
	public void setJwt(String jwt) {
		this.jwt = jwt;
	}
	
	
}

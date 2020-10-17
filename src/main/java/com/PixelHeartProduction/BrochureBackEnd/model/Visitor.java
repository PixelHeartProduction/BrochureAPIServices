package com.PixelHeartProduction.BrochureBackEnd.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="visitor")
public class Visitor {
	
	@Id
	@GeneratedValue
	private long id;
	@Column(name="date_time")
	private String dateTime;
	
	public Visitor () {}
	
	public Visitor(String dateTime) {
		super();
		this.dateTime = dateTime;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDateTime() {
		return dateTime;
	}
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
	
	
	
}

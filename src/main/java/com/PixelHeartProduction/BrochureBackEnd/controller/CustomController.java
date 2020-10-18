package com.PixelHeartProduction.BrochureBackEnd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.PixelHeartProduction.BrochureBackEnd.dto.DashboardData;
import com.PixelHeartProduction.BrochureBackEnd.service.DashboardService;

@RestController
@RequestMapping("api/v1")
public class CustomController {
	
	@Autowired
	private DashboardService dashboardService;
	
	@GetMapping("/dashboard")
	public DashboardData getDashboardData() {
		return dashboardService.getData();
	}
	
}

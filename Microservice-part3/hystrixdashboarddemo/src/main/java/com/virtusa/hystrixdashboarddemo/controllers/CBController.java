package com.virtusa.hystrixdashboarddemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.hystrixdashboarddemo.handlers.HystrixHandler;

@RestController
public class CBController {
    @Autowired
	private HystrixHandler hystrixHandler;
	@GetMapping("/cbcustomers")
    public ResponseEntity<String> getCustomers()
    {
    	return this.hystrixHandler.requestHandler();
    }
    
	
}

package com.ribbon.RibbonLoadBalancerDemo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ribbon.RibbonLoadBalancerDemo.Handler.RibbonHandler;

@RestController
public class RibbonController {

	@Autowired
	private RibbonHandler ribbonHandler;
	
	@GetMapping("/rlbcustomers")
	public ResponseEntity<?> getCustomers(){
		return this.ribbonHandler.findCustomers();
	}
}

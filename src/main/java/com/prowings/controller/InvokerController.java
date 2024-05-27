package com.prowings.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.prowings.service.InvokerService;

import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
public class InvokerController {
	
	@Autowired
	InvokerService invokerService;
	
	@GetMapping("/test-circuit-breaker/{city}")
	public ResponseEntity<String> getClimate(@PathVariable String city)
	{
		log.info("request received to get city from climate api...");
		
		String response = invokerService.getClimate(city);
		
		log.info("request completed successfully...");
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}

	
	@GetMapping("/test-rate-limiter/{city}")
	public ResponseEntity<String> getClimateByCity(@PathVariable String city)
	{
		log.info("request received to get city from climate api...");
		
		String response = invokerService.getClimate(city);
		
		log.info("request completed successfully...");
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}

}

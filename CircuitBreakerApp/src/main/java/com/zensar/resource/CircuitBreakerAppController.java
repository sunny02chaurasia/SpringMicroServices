package com.zensar.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class CircuitBreakerAppController {
	
	@Autowired
	@LoadBalanced
	RestTemplate restTemplate;
	
	@GetMapping("/curcuitBreaker/get")
	@HystrixCommand(fallbackMethod = "unknown")
	public String getResult() {
		String result = restTemplate.getForObject("http://hr-ms/hr/get", String.class);
		return result;
	}
	
	
	private String unknown() {
		return "Failed to get Data from MicroService App";
	}
	
}

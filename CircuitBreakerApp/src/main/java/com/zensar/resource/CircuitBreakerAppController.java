package com.zensar.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.zensar.proxy.HRSeriveProxy;

@RestController
public class CircuitBreakerAppController {
	
	@Autowired
	@LoadBalanced
	RestTemplate restTemplate;
		
	
	@Autowired
	HRSeriveProxy hrProxy;
	
	
	@GetMapping("/curcuitBreaker/get")
	@HystrixCommand(fallbackMethod = "unknown")
	public String getResult() {
		String result = restTemplate.getForObject("http://hr-ms/hr/get", String.class);
		return result;
	}
	
	
	@SuppressWarnings("unused")
	private String unknown() {
		return "Failed to get Data from MicroService App";
	}
	
	
	@GetMapping("/get")
	@HystrixCommand(fallbackMethod = "unknown")
	public String getHR() {
		String result = hrProxy.getHr();
		return result;
	}
	
	@GetMapping("/getHR")
	@HystrixCommand(fallbackMethod = "unknown")
	public String getHRUsingZuul() {
		/**
		 * In Below API we have provided name like zuul-edge-service two times because 1st one is to look for 
		 * that service in Discovery Server and 2nd is for the context path as we have setup in our Micro-service
		 * next we have provided the two /hr first one to mapped with properties in 
		 * 
		 * Zuul Service like -  "zuul.routes.hr.url=http://localhost:8080/hr-ms/" as you can see reversed proxy is mapped 
		 * with url " http://localhost:8080/hr-ms/ " so any rest URI should go after this.
		 * 1st /hr is for looking for mapping in Zuul and 2nd is for HRController is having /hr at top.
		 */
		String result = restTemplate.getForObject("http://zuul-edge-service/zuul-edge-service/hr/hr/get",String.class);
		return result;
	}
	
	
}

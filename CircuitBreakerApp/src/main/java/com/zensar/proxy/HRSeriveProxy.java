package com.zensar.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "hr-ms") //Service Id of HR service
public interface HRSeriveProxy {
	
	@RequestMapping("/hr/get")
	public String getHr(); 
	
}

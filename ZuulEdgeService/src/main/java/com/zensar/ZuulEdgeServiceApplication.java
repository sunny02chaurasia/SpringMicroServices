package com.zensar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.zensar.filters.ZuulErrorFilter;
import com.zensar.filters.ZuulPostFilter;
import com.zensar.filters.ZuulPreFilter;
import com.zensar.filters.ZuulRouteFilter;

@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
public class ZuulEdgeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulEdgeServiceApplication.class, args);
	}
	
	@Bean
	public ZuulPreFilter preFilter() {
		return new ZuulPreFilter();
	}

	@Bean
	public ZuulPostFilter postFilter() {
		return new ZuulPostFilter();
	}

	@Bean
	public ZuulErrorFilter errorFilter() {
		return new ZuulErrorFilter();
	}

	@Bean
	public ZuulRouteFilter routeFilter() {
		return new ZuulRouteFilter();
	}
	
}

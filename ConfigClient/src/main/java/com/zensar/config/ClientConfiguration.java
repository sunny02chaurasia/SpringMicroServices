package com.zensar.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("some.other")
public class ClientConfiguration {
	
	private String property;

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public ClientConfiguration(String property) {
		super();
		this.property = property;
	}

	public ClientConfiguration() {
		super();
	}
}

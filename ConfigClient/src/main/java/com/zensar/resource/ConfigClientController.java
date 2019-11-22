package com.zensar.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.config.ClientConfiguration;

@RestController
public class ConfigClientController {

	/**
	 * Below property is mapped with spring.application.name which will look for
	 * Config file in Config Server. If no spring.application.name is given then it
	 * will look into global application.properties file. Else throw error
	 */
	@Value("${some.property}")
	private String someProperty;

	@Autowired
	private ClientConfiguration property;

	@GetMapping(value = "/client/get")
	public String getClientPropreties() {
		return someProperty;
	}

	@GetMapping(value = "/client/getUpdated")
	public String getClientPropretiesUpdated() {
		StringBuffer br = new StringBuffer();
		br.append(property.getProperty());
		br.append(" || ");
		br.append(someProperty);
		return br.toString();
	}

}

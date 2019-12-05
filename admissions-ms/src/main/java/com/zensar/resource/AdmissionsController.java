package com.zensar.resource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.zensar.model.Patient;

@RestController
@RequestMapping("/admissions")
public class AdmissionsController {
	
	@Autowired
	@LoadBalanced
	RestTemplate restTemplate;
	
	private List<Patient> patients = new ArrayList<Patient>(
			Arrays.asList(new Patient("P1", "Ram"), new Patient("P2", "Rohit"), new Patient("P1", "Ajay")));

	
	@RequestMapping(value = "/patients", method = RequestMethod.GET)
	public List<Patient> getPatients() {
		return patients;
	}
	
	@RequestMapping(value = "/employees", method = RequestMethod.GET)
	public String getEmployees() {
		//String emp  = restTemplate.getForObject("http://localhost:8080/hr/employees",String.class,null);
		String emp  = restTemplate.getForObject("http://hr-ms/hr-ms/hr/get",String.class);
		System.out.println(emp);
		return emp;
	}
}

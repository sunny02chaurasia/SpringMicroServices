package com.zensar.resource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.model.Employee;

@RestController
@RequestMapping("/hr")
public class HRController {

	private List<Employee> employees = new ArrayList<Employee>(Arrays.asList(new Employee(1001, "AL", 10000),
			new Employee(1002, "BL", 10000), new Employee(1003, "CL", 10000)));
	
	
	@GetMapping(value = "/employees")
	public List<Employee> getAllEmployees(){
		return employees;
	}
	
	
}

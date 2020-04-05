package com.program.endpointstesting.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;

import com.program.endpointstesting.model.employeedetails;
import com.program.endpointstesting.service.empservice;


@Service
@RestController
@ComponentScan
public class employeeController {
	
	@Autowired
	private empservice employeeservice;

	
	@RequestMapping("/emp")
	public List<employeedetails> getEmployee()
	
	{
		return employeeservice.getAll();
				}
	
	@RequestMapping("/emp/{empId}")
	public employeedetails getEmployees(@PathVariable int empId)
	{
		return employeeservice.getbyid(empId);
	}
	
	
	@RequestMapping(method=RequestMethod.POST, value = "/emp")
	public void addEmployees(@RequestBody employeedetails empdetail)
	{
	  	 employeeservice.addEmployees(empdetail);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value = "/emp/{empId}")
	public void updateEmployees(@RequestBody employeedetails empdetail, @PathVariable int empId)
	{
	  	 employeeservice.updateEmployees(empId, empdetail);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/emp/{empId}")
	public void deleteEmployees(@PathVariable int empId)
	{
		 employeeservice.deleteEmployees(empId);
	}

	
	
}

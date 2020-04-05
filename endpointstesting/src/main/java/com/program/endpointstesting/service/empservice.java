package com.program.endpointstesting.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.program.endpointstesting.model.employeedetails;

@Service
public class empservice {
	
	private List<employeedetails> s = new ArrayList<>(Arrays.asList(
			
			new employeedetails(1,"sp",234),
			new employeedetails(5,"lop",321)
		
			));
	
	public List<employeedetails> getAll()
	{
		return s;
	}
	
	public employeedetails getbyid(int empId)
	
	{
		
	
		return s.stream().filter(t -> t.getEmpId() == empId).findFirst().get();
		
	}

	public void addEmployees(employeedetails empdetail) {
		
		s.add(empdetail);
		
	}

	public void updateEmployees(int empId, employeedetails empdetail) {
		
		for(int i=0;i<s.size();i++)
		{
			employeedetails t = s.get(i);
			if(t.getEmpId()== empId)
			{
				s.set(i, empdetail);
				return;
			}
		}
		
		
	}

	public void deleteEmployees(int empId) {
		
		s.removeIf(t -> t.getEmpId()==empId);
		
	}
	
	
	
	

}

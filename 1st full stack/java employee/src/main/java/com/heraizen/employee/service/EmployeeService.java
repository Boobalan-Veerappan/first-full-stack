package com.heraizen.employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heraizen.employee.dao.EmployeeDetailsService;
import com.heraizen.employee.dto.EmployeeDetails;
import com.heraizen.employee.exception.DataNotFoundException;
import com.heraizen.employee.exception.EmployeeAlreadyExistException;
import com.heraizen.employee.repo.EmployeeDetailsRepo1;


@Service
public class EmployeeService {

	@Autowired
	EmployeeDetailsService details;
	
	@Autowired
	EmployeeDetailsRepo1 repo;
	
	public EmployeeDetails addEmployee( EmployeeDetails emp)throws EmployeeAlreadyExistException
	{
		
		return details.addEmployee(emp);
	}
	
	public List<EmployeeDetails> allEmployee()
	{
		return details.allEmplyee();
		
	}
	
	public EmployeeDetails SearchById(String Id) throws DataNotFoundException
	{
		Optional<EmployeeDetails> opt = repo.findById(Id);
		
		if(!opt.isPresent())
		{
			throw new DataNotFoundException("Data Not Availale");
			
		}
		
		return details.SearchById(Id);
	}
	public boolean deletebyId(String Id) throws DataNotFoundException
	{
		Optional<EmployeeDetails> opt = repo.findById(Id);
		if(!opt.isPresent())
		{
			throw new DataNotFoundException("Data Not Availale");
		}
		return details.deleteById(Id);
	}
	
	public EmployeeDetails updateEmployee(EmployeeDetails emp) throws DataNotFoundException
	{
		Optional<EmployeeDetails> opt = repo.findById(emp.get_id());
		if(!opt.isPresent())
		{
			throw new DataNotFoundException("Data Not Availale");
		}
		
		return details.updateEmployee(emp);
	}
	
	public EmployeeDetails  SearchName(String Name) throws DataNotFoundException
	{
		return details.SearchByName(Name);
	}
	
}

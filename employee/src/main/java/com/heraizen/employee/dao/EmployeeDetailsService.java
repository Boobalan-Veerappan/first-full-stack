package com.heraizen.employee.dao;

import java.util.List;

import com.heraizen.employee.dto.EmployeeDetails;
import com.heraizen.employee.exception.DataNotFoundException;
import com.heraizen.employee.exception.EmployeeAlreadyExistException;


public interface EmployeeDetailsService {
	
	public EmployeeDetails addEmployee(EmployeeDetails employee)throws EmployeeAlreadyExistException;
	
	public List<EmployeeDetails> allEmplyee();
	
	public EmployeeDetails SearchById(String Id);
	
	public EmployeeDetails  SearchByName(String Name) throws DataNotFoundException;
	
	public boolean deleteById(String Id);
	
	public EmployeeDetails updateEmployee(EmployeeDetails employee);
}

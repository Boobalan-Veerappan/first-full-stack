package com.heraizen.employee.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.heraizen.employee.dao.EmployeeDetailsImpl;
import com.heraizen.employee.dto.EmployeeDetails;
import com.heraizen.employee.exception.DataNotFoundException;
import com.heraizen.employee.exception.EmployeeAlreadyExistException;
import com.heraizen.employee.service.EmployeeService;




@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/emp/")
public class EmployeeController {

	@Autowired
	EmployeeService service;
	

	
	@GetMapping("add")
	public String addTeam() {
		return "Hello";
	}
	
	@PostMapping("addemp")
	public EmployeeDetails addemp(@RequestBody EmployeeDetails employee) throws EmployeeAlreadyExistException
	{
		System.out.println("1"+employee.getEmp_name());
		return service.addEmployee(employee);
	}
	
	@GetMapping("all")
	public List<EmployeeDetails> allemployee()
	{
		System.out.println("inside employee controller");
		return service.allEmployee();
	}
	
	@GetMapping("search/{id}")
	public EmployeeDetails searchEmplyeeById(@PathVariable("id") String id) throws DataNotFoundException 
	{
		return service.SearchById(id);
	}
	@DeleteMapping("delete/{id}")
	public boolean deleteById(@PathVariable("id") String id) throws DataNotFoundException 
	{
	
		return service.deletebyId(id);
	}
	
	
	@GetMapping("searchName/{name}")
	public EmployeeDetails searchByName(@PathVariable("name") String name) throws DataNotFoundException
	{
		return service.SearchName(name);
	}
	
	
	@PutMapping("update")
	public EmployeeDetails updateEmployeeById(@RequestBody EmployeeDetails employee) throws DataNotFoundException {
		
		return service.updateEmployee(employee);
	}
	
	
}

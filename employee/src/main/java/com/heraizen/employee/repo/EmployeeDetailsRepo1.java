package com.heraizen.employee.repo;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.heraizen.employee.dto.EmployeeDetails;


public interface EmployeeDetailsRepo1 extends MongoRepository<EmployeeDetails, String> {



	
	
}

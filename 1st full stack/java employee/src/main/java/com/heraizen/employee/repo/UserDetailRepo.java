package com.heraizen.employee.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.heraizen.employee.dto.UserData;


public interface UserDetailRepo extends MongoRepository<UserData, String>{

	
}

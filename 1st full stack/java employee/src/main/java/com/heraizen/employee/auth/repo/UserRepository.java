package com.heraizen.employee.auth.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.heraizen.employee.auth.model.User;



public interface UserRepository extends MongoRepository<User, String> {
	User findByEmail(String email);

}
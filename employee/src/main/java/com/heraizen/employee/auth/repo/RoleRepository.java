package com.heraizen.employee.auth.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.heraizen.employee.auth.model.Role;


public interface RoleRepository extends MongoRepository<Role, String> {
	Role findByRole(String role);
}

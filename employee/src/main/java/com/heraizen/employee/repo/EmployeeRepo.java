package com.heraizen.employee.repo;

import org.springframework.stereotype.Repository;

import com.heraizen.employee.dto.BookList;

import org.springframework.data.mongodb.repository.MongoRepository;


public interface EmployeeRepo extends MongoRepository<BookList, String> {

}

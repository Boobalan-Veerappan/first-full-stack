package com.heraizen.employee.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import com.heraizen.employee.auth.model.Role;
import com.heraizen.employee.auth.model.User;
import com.heraizen.employee.auth.repo.RoleRepository;
import com.heraizen.employee.auth.repo.UserRepository;
import com.heraizen.employee.dto.EmployeeDetails;
import com.heraizen.employee.exception.DataNotFoundException;
import com.heraizen.employee.exception.EmployeeAlreadyExistException;
import com.heraizen.employee.repo.EmployeeDetailsRepo1;

@Repository
public class EmployeeDetailsImpl implements EmployeeDetailsService {
	private static Logger log = LoggerFactory.getLogger(EmployeeDetailsImpl.class);

	@Autowired
	EmployeeDetailsRepo1 emprepo;

	@Autowired
	MongoOperations mongo;

	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public EmployeeDetails addEmployee(EmployeeDetails employee) throws EmployeeAlreadyExistException {
		
		
		MatchOperation match =	Aggregation.match(Criteria.where("emp_email").is(employee.getEmp_email()));
		Aggregation query = Aggregation.newAggregation(match);
		AggregationResults<EmployeeDetails> empRes = mongo.aggregate(query, "employeeDetails", EmployeeDetails.class);
		List<EmployeeDetails> employeeList = empRes.getMappedResults();
		
		
		
		if(employeeList.isEmpty())
		{
			Assert.notNull(employee, "Employee can not be null");
			Role role1 = new Role();
			role1.setRole(employee.getEmp_position());
			role1 = roleRepository.save(role1);
			User user = new User();
			user.setEmail(employee.getEmp_email());
			user.setPassword(bCryptPasswordEncoder.encode("admin@123!"));
			user.setEnabled(true);
			user.addRole(role1);
			userRepository.save(user);
			return emprepo.save(employee);
			
		}
		else
		{
			throw new EmployeeAlreadyExistException("This Employee Email id  is Already Exist");
		}
		
		
	}

	@Override
	public List<EmployeeDetails> allEmplyee() {

		List<EmployeeDetails> li = mongo.findAll(EmployeeDetails.class);
		log.info("List of Employee is {} ", li);
		log.info("List of Employee Size is {} ", li.size());

		return mongo.findAll(EmployeeDetails.class);

	}

	@Override
	public EmployeeDetails SearchById(String Id) {

		Assert.notNull(Id, "Id can not be null");
		Optional<EmployeeDetails> opt = emprepo.findById(Id);
		EmployeeDetails e = opt.get();
		log.info("Search Employee Id Result is {} ", e);
		return e;
	}

	@Override
	public EmployeeDetails SearchByName(String Name) throws DataNotFoundException {
	
		
		Assert.notNull(Name, "Searching string can not be null");
		log.info("Name: {}", Name);
		MatchOperation match = Aggregation.match(Criteria.where("emp_email").is(Name));
		Aggregation query = Aggregation.newAggregation(match);
		log.info("Query" + query);
		
		AggregationResults<EmployeeDetails> empRes = mongo.aggregate(query, "employeeDetails", EmployeeDetails.class);
		List<EmployeeDetails> employeeList = empRes.getMappedResults();
		
		if(employeeList.isEmpty())
		{
			throw new DataNotFoundException("Data Not FOund");
		}
		
		return employeeList.get(0);
	}

	@Override
	public boolean deleteById(String Id) {
		Assert.notNull(Id, "Id can not be null");
		log.info("Deleted Employee Id  is {} ", Id);
		emprepo.deleteById(Id);

		return true;
	}

	@Override
	public EmployeeDetails updateEmployee(EmployeeDetails employee) {
		
		Assert.notNull(employee, "Id can not be null");
		
		log.info("update Employee is {}",employee);
		
		Query updateQuery = new Query();
		Update update = new Update();
		update.set("emp_name", employee.getEmp_name());
		update.set("emp_email", employee.getEmp_email());
		update.set("emp_mobile", employee.getEmp_mobile());
		update.set("emp_dob",employee.getEmp_dob());
		update.set("emp_address",employee.getEmp_address());
		update.set("emp_doj",employee.getEmp_doj());
		update.set("emp_position",employee.getEmp_position());
		update.set("image_url",employee.getImage_url());
		
		updateQuery.addCriteria(Criteria.where("_id").is(employee.get_id()));
		
		log.info("update Employee query   is {} ",updateQuery);
		mongo.updateFirst(updateQuery, update, EmployeeDetails.class);
		
		

		return employee;
		
		
	}

}

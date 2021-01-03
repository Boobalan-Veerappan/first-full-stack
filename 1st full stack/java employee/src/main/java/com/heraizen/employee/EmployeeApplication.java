package com.heraizen.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.heraizen.employee.auth.model.Role;
import com.heraizen.employee.auth.model.User;
import com.heraizen.employee.auth.repo.RoleRepository;
import com.heraizen.employee.auth.repo.UserRepository;
import com.heraizen.employee.repo.EmployeeRepo;
import com.heraizen.employee.repo.UserDetailRepo;



@SpringBootApplication
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class EmployeeApplication implements CommandLineRunner {
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(EmployeeApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		roleRepository.deleteAll();
		userRepository.deleteAll();
		Role role1 = new Role();
		role1.setRole("ROLE_ADMIN");
		role1 = roleRepository.save(role1);
		Role role2 = new Role();
		role2.setRole("USER");
		role2 = roleRepository.save(role2);
		
		User user = new User();
		user.setEmail("raina@gmail.com");
		user.setPassword(bCryptPasswordEncoder.encode("admin@123!"));
		user.setEnabled(true);
		user.addRole(role1);
		userRepository.save(user);
		User user2 = new User();
		user2.setEmail("user@heraizen.com");
		user2.setPassword(bCryptPasswordEncoder.encode("admin@123!"));
		user2.setEnabled(true);
		user2.addRole(role2);
		userRepository.save(user2);
		
		System.out.println("roles : " +roleRepository.findAll());
		System.out.println("users : " +userRepository.findAll());
	}

}

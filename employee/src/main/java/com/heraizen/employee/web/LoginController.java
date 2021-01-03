package com.heraizen.employee.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.heraizen.employee.auth.JwtUtil;
import com.heraizen.employee.auth.model.LoginResponse;
import com.heraizen.employee.auth.model.LoginUser;


@RestController
@RequestMapping("/api/v1/auth/")
public class LoginController {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private UserDetailsService userService;

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private AuthenticationManager authManager;

	@PostMapping("login")
	public ResponseEntity<?> login(@RequestBody LoginUser loginUser) {
		
		
		log.info("{}", loginUser);
		UserDetails userDetails = validateUser(loginUser);
		String token = jwtUtil.generateToken(userDetails);
		LoginResponse loginResponse = LoginResponse.builder().token(token).details(userDetails).build();
	
		return ResponseEntity.ok(loginResponse);
	}

	private UserDetails validateUser(LoginUser loginUser) {
		try {
			UserDetails userDetails = userService.loadUserByUsername(loginUser.getUsername());
			if (userDetails != null) {

				authManager.authenticate(
						new UsernamePasswordAuthenticationToken(loginUser.getUsername(), loginUser.getPassword()));
				return userDetails;
			}

		} catch (Exception e) {
			throw new BadCredentialsException("User with details not found or bad credentials");
		}
		throw new BadCredentialsException("User with details not found or bad credentials");
	}

	@GetMapping("hello")
	public String message() {
		
		return "Hello";
	
	}
}

package com.heraizen.employee.auth.model;

import org.springframework.security.core.userdetails.UserDetails;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginResponse {

	private String token;
	private UserDetails details;
}

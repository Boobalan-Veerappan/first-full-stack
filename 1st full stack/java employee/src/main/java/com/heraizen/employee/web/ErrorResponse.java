package com.heraizen.employee.web;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class ErrorResponse {


	private LocalDateTime dateTime;
	private int status;
	private String message;
	
}

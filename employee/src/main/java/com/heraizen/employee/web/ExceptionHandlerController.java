package com.heraizen.employee.web;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.heraizen.employee.exception.DataNotFoundException;
import com.heraizen.employee.exception.EmployeeAlreadyExistException;



@ControllerAdvice
public class ExceptionHandlerController extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(value = {EmployeeAlreadyExistException.class})
	public ResponseEntity<ErrorResponse> handleConflict1(Exception ex, WebRequest request) {
		ErrorResponse errorResponse=ErrorResponse.builder().status(HttpStatus.CONFLICT.value()).message(ex.getMessage()).dateTime(LocalDateTime.now()).build();
		return new ResponseEntity<ErrorResponse>(errorResponse,HttpStatus.CONFLICT);
	}
	@ExceptionHandler(value = {DataNotFoundException.class})
	public ResponseEntity<ErrorResponse> handleConflict2(Exception ex, WebRequest request) {
		ErrorResponse errorResponse=ErrorResponse.builder().status(HttpStatus.CONFLICT.value()).message(ex.getMessage()).dateTime(LocalDateTime.now()).build();
		return new ResponseEntity<ErrorResponse>(errorResponse,HttpStatus.CONFLICT);
	}
}

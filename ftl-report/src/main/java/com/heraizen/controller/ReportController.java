package com.heraizen.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.heraizen.mail.AppEmailService;

import lombok.Getter;
@RestController
@RequestMapping("/api/v1/team/")
public class ReportController {

//	@Autowired
//	public AppEmailService mail;
	
	@GetMapping("report")
	public void report()
	{
		
	}
}

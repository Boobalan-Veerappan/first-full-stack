package com.heraizen.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.heraizen.aop.service.ArithMeticOperation;

@SpringBootApplication
public class AopApplication implements CommandLineRunner{

	@Autowired
	ArithMeticOperation a;
	
	public static void main(String[] args) {
		SpringApplication.run(AopApplication.class, args);
	}

	
	@Override
	public void run(String... args) throws Exception {
		
		a.sum(3, 10);
		a.sum(5, 5);
		
		a.divide(10, 5);
	}

}

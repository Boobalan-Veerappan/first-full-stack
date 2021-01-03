package com.heraizen.ftlreport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.heraizen.mail.AppEmailService;

@SpringBootApplication
public class FtlReportApplication implements CommandLineRunner {

	@Autowired
	public AppEmailService mail;
	
	
	public static void main(String[] args) {
		SpringApplication.run(FtlReportApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		mail.sendSimpleMessage("boobalanv2016@gmail.com", "dfsfs", "fsddddd");
		
	}

}

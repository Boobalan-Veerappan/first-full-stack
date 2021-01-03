package com.heraizen.christmasfriend;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import com.heraizen.christmasfriend.domain.X_masDetails;
import com.heraizen.christmasfriend.utils.utilReader;

import freemarker.template.Configuration;
import freemarker.template.Template;

@SpringBootApplication
public class ChristmasfriendApplication implements CommandLineRunner {

	

	@Autowired
	private christmas christmas;
	List<X_masDetails> data = new ArrayList<>();
	public static void main(String[] args) throws Exception {
		

		
		SpringApplication.run(ChristmasfriendApplication.class, args);

		
	}

	@Override
	public void run(String... args) throws Exception {


	}

}

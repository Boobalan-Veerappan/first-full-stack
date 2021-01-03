package com.heraizen.mail;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class AppEmailService {

	@Autowired
	private JavaMailSender emailSender;
	
	
	public void sendSimpleMessage(String to,String subject,String text)
	{
		MimeMessage message = emailSender.createMimeMessage();
		 MimeMessageHelper helper;
		 try {
			 helper = new MimeMessageHelper(message, true);
			 helper.setFrom("noreply@heraizen.com");
			 helper.setTo(to); 
			 helper.setSubject(subject); 
			 helper.setText("<h2>Happy New Year ",true);
	        emailSender.send(message);
			 
		 } catch(MessagingException e) {
			 
			 
			 e.printStackTrace();
		 }
		
	}
	
}

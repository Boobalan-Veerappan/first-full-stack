package com.heraizen.ftl.project;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.io.Writer;
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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.heraizen.ftl.configuration.Product;
import com.heraizen.ftl.configuration.Student;
import com.heraizen.ftl.configuration.Subject;
import com.heraizen.ftl.javamail.AppEmailService;

import org.springframework.mail.javamail.MimeMessageHelper;

import freemarker.core.ParseException;
import freemarker.template.Configuration;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;

@SpringBootApplication
public class FtlProjectApplication implements CommandLineRunner {
	@Autowired
	JavaMailSender emailSender;

	@Autowired
	Configuration config;

	@Autowired
	Configuration cfg;
	static List<Student> result = new ArrayList<>();
	private static final String fileNmae = "/Students.json";

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper obj = new ObjectMapper();
		result = obj.readValue(FtlProjectApplication.class.getResourceAsStream(fileNmae),
				new TypeReference<List<Student>>() {
				});

		System.out.println("#######$$$$%%%%" + result);

		SpringApplication.run(FtlProjectApplication.class, args);
	}

	public void optGenerete1() throws TemplateNotFoundException, MalformedTemplateNameException, ParseException,
			IOException, TemplateException {
		Map<String, Object> map = new HashMap<>();
		map.put("userName", "Krish");
		map.put("otp", "12345");
		map.put("secound", "34");
		map.put("applicaiton", "POD");
		// map.put(key, remappingFunction);

		Template temp = cfg.getTemplate("otp.ftl");
		Writer out = new OutputStreamWriter(System.out);
		StringWriter strwriter = new StringWriter();
		temp.process(map, strwriter);
		System.out.println(strwriter);
		System.out.println("<---------------------------------------------------->");
	}

	public void orderBooking() throws TemplateNotFoundException, MalformedTemplateNameException, ParseException,
			IOException, TemplateException {
		Map<String, Object> map = new HashMap<>();
		Template temp1 = cfg.getTemplate("product.ftl");
		map.put("customer", "boobalan");
		Product p1 = new Product("lap", "www.laptop.com");
		Product p2 = new Product("lap", "www.laptop.com");
		Product p3 = new Product("lap", "www.laptop.com");
		List<Product> pro = new ArrayList<>();

		pro.add(p1);
		pro.add(p2);
		pro.add(p3);
		map.put("products", pro);
		Writer out = new OutputStreamWriter(System.out);
		StringWriter strwriter = new StringWriter();
		temp1.process(map, strwriter);
		System.out.println(strwriter);
		System.out.println("<---------------------------------------------------->");
	}

	public void studentreport() throws Exception {

		result.forEach(e->{
		
		MimeMessage message = emailSender.createMimeMessage();
		MimeMessageHelper helper = null;

		Map<String, Object> map = new HashMap<>();
	
		Template temp2 = null;
		try {
			temp2 = config.getTemplate("table.ftl");
		} catch (IOException e2) {

			e2.printStackTrace();
		}
		map.put("table", e);
		Writer out = new OutputStreamWriter(System.out);
		StringWriter strwriter = new StringWriter();
		try {
			temp2.process(map, strwriter);
		} catch (TemplateException | IOException e1) {
			
			e1.printStackTrace();
		}
		String body = strwriter.toString();
		try {
			helper = new MimeMessageHelper(message, true);
			helper.setFrom("noreply@heraizen.com");
			helper.setTo("boobalanv2016@gmail.com");
			helper.setSubject("Result Publish");
			helper.setText(body, true);
		} catch (MessagingException e1) {
			
			e1.printStackTrace();
		}
		
		System.out.println(strwriter);

		emailSender.send(message);

		System.out.println("<---------------------------------------------------->");
		});
	}

	@Override
	public void run(String... args) throws Exception {

		optGenerete1();
		orderBooking();
		// AppEmailService.sendSimpleMessage("boobalanv2016@gmail.com", "bday",
		// "thanks");

		//studentreport();
	}

}
@RestController
class ApiController{
	@GetMapping("/product/")
	public List<Product> product() {
		Product p1 = new Product("lap", "www.laptop.com");
		Product p2 = new Product("lap", "www.laptop.com");
		Product p3 = new Product("lap", "www.laptop.com");
		List<Product> pro = new ArrayList<>();

		pro.add(p1);
		pro.add(p2);
		pro.add(p3);
		return pro;
	}
	
}



package com.heraizen.ftl.project;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.heraizen.ftl.javamail.AppEmailService;

import freemarker.core.ParseException;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;





@RestController
public class ReportController {

	
	
@GetMapping("score")
public String score() throws TemplateNotFoundException, MalformedTemplateNameException, ParseException, IOException, TemplateException
{
	
	
	
	return "Success";
}
	
}

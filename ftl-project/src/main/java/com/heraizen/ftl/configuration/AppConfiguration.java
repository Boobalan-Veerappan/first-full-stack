package com.heraizen.ftl.configuration;

import org.springframework.boot.autoconfigure.freemarker.FreeMarkerAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.ui.freemarker.FreeMarkerConfigurationFactory;

import com.heraizen.ftl.javamail.AppEmailService;

import org.springframework.mail.javamail.JavaMailSender;
public class AppConfiguration {
	

	@Bean
	public FreeMarkerConfigurationFactory fltfactory()
	{
		FreeMarkerConfigurationFactory ftl = new FreeMarkerConfigurationFactory();
		ftl.setTemplateLoaderPath("classpath:/templates");
		ftl.setDefaultEncoding("UTF-8");
		return ftl;
	}
	
//	@Bean
//	public AppEmailService mail()
//	{
//		return new AppEmailService();
//	}
	
}

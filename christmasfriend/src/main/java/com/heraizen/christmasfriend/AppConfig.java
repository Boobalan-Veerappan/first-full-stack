package com.heraizen.christmasfriend;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ui.freemarker.FreeMarkerConfigurationFactory;

@Configuration
public class AppConfig {

	@Bean
	public FreeMarkerConfigurationFactory ftlFactory() {
		
		FreeMarkerConfigurationFactory freeMarkerConfigurer=new FreeMarkerConfigurationFactory();
		freeMarkerConfigurer.setTemplateLoaderPath("classpath:/templates");
		freeMarkerConfigurer.setDefaultEncoding("UTF-8");
		return freeMarkerConfigurer;
		
	}
}

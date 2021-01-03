package com.heraizen.uploadFile;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.heraizen.uploadFile.web.UploadController;

@Configuration
public class Appconfiguration {

	@Bean
	public UploadController upload()
	{
		return new UploadController();
	}
	
}

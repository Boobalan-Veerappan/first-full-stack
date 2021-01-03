package com.heraizen.uploadFile;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

import com.heraizen.uploadFile.filedemo.FileStorageProperties;
import com.heraizen.uploadFile.web.UploadController;

@SpringBootApplication(scanBasePackages={
		"com.example.service", "com.example.web"})
@ComponentScan(basePackageClasses = UploadController.class)

@EnableConfigurationProperties({
	
	FileStorageProperties.class
})
public class UploadFileApplication implements CommandLineRunner{

	
	
	public static void main(String[] args) throws IOException {
		File file = new File("/home/spaneos/Videos/text.txt");
		if(file.createNewFile())
		{
			System.out.println("Create File");
		}
		else
		{
			System.out.println("alreay");
		}
		
		int a= 10;
		FileWriter writer = new FileWriter(file);
		writer.write("Test data"+a);
		writer.write("Test data1");
		writer.close();
		
		SpringApplication.run(UploadFileApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	
	}

}

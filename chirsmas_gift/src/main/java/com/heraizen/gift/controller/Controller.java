package com.heraizen.gift.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.heraizen.gift.domain.FileDetails;

@RestController
@RequestMapping("/api")
public class Controller {
	private static final Logger log = LoggerFactory.getLogger(Controller.class);
	@PostMapping("/upload")
	public FileDetails uploadFile(@RequestBody MultipartFile file) throws IOException {

		String fileName = file.getOriginalFilename();
		log.info(fileName + "fileName");
		log.info("Request for uploadig file:{}", fileName + "and withsize:" + file.getSize());
		String path = System.getProperty("java.io.tmpdir");
		System.out.println(System.getProperty("java.io.tmpdir") + "testing");
		path = path + "/uploads/" + fileName;
		File f = new File(path);
		f.createNewFile();
		System.out.println("----" + f.exists());
		Files.write(Paths.get(path), file.getBytes());
		log.info("file with name: {} is uploaded at :{}", fileName, f.getPath());
		FileDetails obj = FileDetails.builder().name(fileName).build();
		return obj;

	}
	
}

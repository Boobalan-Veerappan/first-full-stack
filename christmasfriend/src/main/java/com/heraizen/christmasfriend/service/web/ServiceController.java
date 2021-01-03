package com.heraizen.christmasfriend.service.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.heraizen.christmasfriend.domain.FileDetails;
import com.heraizen.christmasfriend.impl.scantaimpelment;
import com.heraizen.christmasfriend.utils.utilReader;

@RestController
@RequestMapping("/api/files")
public class ServiceController {

	@Autowired
	scantaimpelment scan;
	private static final Logger log = LoggerFactory.getLogger(ServiceController.class);

	@PostMapping("/upload")
	public FileDetails uploadFile(@RequestBody MultipartFile file) throws Exception {

		String fileName = "FriendsDetails.json";
		log.info(fileName + "fileName");
		log.info("Request for uploadig file:{}", fileName + "and withsize:" + file.getSize());
		String path = System.getProperty("java.io.tmpdir");
		System.out.println(System.getProperty("java.io.tmpdir") + "testing");
		path = path + "/upload/" + fileName;
		File f = new File(path);
		f.createNewFile();
		System.out.println("----" + f.exists());
		Files.write(Paths.get(path), file.getBytes());
		log.info("file with name: {} is uploaded at :{}", fileName, f.getPath());
		
		
		scan.sceretScanta();
		
		
		FileDetails obj = FileDetails.builder().name(file.getOriginalFilename()).build();
		return obj;

	}

	
	@GetMapping("/download")
	public ResponseEntity<?> downloadFile() throws FileNotFoundException {
		String path = System.getProperty("java.io.tmpdir");

		path = path + "/upload/" + "text.txt";
		File file = new File(path);

		InputStreamResource resource=new InputStreamResource(new FileInputStream(file));
		
		return ResponseEntity.ok().contentLength(file.length()).contentType(MediaType.APPLICATION_OCTET_STREAM).body(resource);

	}
	
}

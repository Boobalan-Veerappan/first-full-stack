package com.heraizen.uploadFile.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import com.heraizen.service.UploadService;
import com.heraizen.uploadFile.payload.UploadFileResponse;
import com.heraizen.uploadFile.service.FileStorageService;

import org.springframework.web.bind.annotation.RestController;
import lombok.Getter;

@RestController
@RequestMapping("/api/v1/team/")
@ComponentScans({
@ComponentScan(basePackages = "com.heraizen.service"),
@ComponentScan(basePackages = "com.heraizen.uploadFile.service")
})
public class UploadController {

	@Autowired
	public UploadService upl;
	
	 @Autowired
	    private FileStorageService fileStorageService;
	
	@GetMapping("repeat")
	public String repeat()
	{
		return "boobalan";
	}
	 @RequestMapping(value = "/file", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	 public UploadFileResponse uploadFile(@RequestParam("file") MultipartFile file) {
		 String fileName = fileStorageService.storeFile(file);
		 String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
	                .path("/downloadFile/")
	                .path(fileName)
	                .toUriString();
		 
		 return new UploadFileResponse(fileName, fileDownloadUri,
	                file.getContentType(), file.getSize());
	 }
	
}

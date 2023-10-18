package com.bcbsm.mail.controller;

import java.io.IOException;
import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bcbsm.mail.model.EmailDetails;
import com.bcbsm.mail.model.FileDocument;
import com.bcbsm.mail.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.bcbsm.mail.exception.EmailManagementException;
import com.bcbsm.mail.service.FileManagerService;

@RequestMapping("/files")
@RestController
public class EmailController {

	@Autowired
	private FileManagerService fileManagerService;

	@Autowired
	private EmailService emailService;

	@GetMapping
	public Map<String, Object> home(Principal loggedInUser) {
		Map<String, Object> model = new HashMap<>();
		model.put("username", loggedInUser.getName());
		return model;
	}

	@GetMapping(value =  "/download", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	public ResponseEntity<Resource> downloadAttachment(@RequestParam("id") String fileId)
			throws IOException {

		FileDocument fileDocument = fileManagerService.downloadFile(fileId);

		return ResponseEntity.ok()
				.contentType(MediaType.parseMediaType(fileDocument.getFileType()))
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileDocument.getFilename() + "\"")
				.body(new ByteArrayResource(fileDocument.getFile()));
	}

	@GetMapping("/list")
	@ResponseBody
	public ResponseEntity<List<EmailDetails>> getSentEmailDetails()
			throws EmailManagementException, IOException {
		List<EmailDetails> emailDetailsList = fileManagerService.listAllFiles();
		return ResponseEntity.ok().body(emailDetailsList);
	}

	@PostMapping("/upload")
	public ResponseEntity<?> upload(@RequestPart("file")MultipartFile file, @RequestPart("emailDetails") String emailDetails) throws IOException {
		String uploadFile = fileManagerService.uploadFile(file);
		emailService.sendEmailWithAttachment("sampath.bigdata@gmail.com", file);

		return new ResponseEntity<>(uploadFile, HttpStatus.OK);
	}


}

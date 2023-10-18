package com.bcbsm.mail.service;

import com.bcbsm.mail.model.EmailDetails;
import com.bcbsm.mail.model.FileDocument;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


public interface FileManagerService {

	public String uploadFile(MultipartFile fileUploaded) throws IOException;
	public FileDocument downloadFile(String id) throws IOException;
	public List<EmailDetails> listAllFiles() throws IOException;

}

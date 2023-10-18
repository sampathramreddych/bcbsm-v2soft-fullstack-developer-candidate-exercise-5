package com.bcbsm.mail.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.bcbsm.mail.model.EmailDetails;
import com.bcbsm.mail.model.FileDocument;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.client.gridfs.GridFSFindIterable;
import com.mongodb.client.gridfs.model.GridFSFile;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileManagerServiceImpl implements FileManagerService {

	@Autowired
	private GridFsTemplate template;

	@Autowired
	private GridFsOperations operations;

	@Override
	public String uploadFile(MultipartFile fileUploaded) throws IOException {
		DBObject metadata = new BasicDBObject();
		metadata.put("fileSize", fileUploaded.getSize());

		metadata.put("fromEmailId", "sampath@gmail.com");
		//metadata.put("recipientEmailId", emailDetails.getRecipientEmailId());
		//metadata.put("uploadedBy", emailDetails.getUploadUser());

		Object fileID = template.store(fileUploaded.getInputStream(), fileUploaded.getOriginalFilename(), fileUploaded.getContentType(), metadata);

		return fileID.toString();
	}


	public FileDocument downloadFile(String id) throws IOException {

		//search file
		GridFSFile gridFSFile = template.findOne( new Query(Criteria.where("_id").is(id)) );


		//convert uri to byteArray
		//save data to LoadFile class
		FileDocument fileDocument = new FileDocument();

		if (gridFSFile != null && gridFSFile.getMetadata() != null) {
			fileDocument.setFilename( gridFSFile.getFilename() );

			fileDocument.setFileType( gridFSFile.getMetadata().get("_contentType").toString() );

			fileDocument.setFileSize( gridFSFile.getMetadata().get("fileSize").toString() );

			fileDocument.setFile( IOUtils.toByteArray(operations.getResource(gridFSFile).getInputStream()) );
		}

		return fileDocument;
	}


	public List<EmailDetails> listAllFiles() throws IOException {

		//search file

		List<EmailDetails> emailDetailsList = new ArrayList<>();
		GridFSFindIterable gridFSFiles =  operations.find(new Query().limit(20));

		for(GridFSFile file:gridFSFiles) {
			EmailDetails emailDetails = new EmailDetails();
			emailDetails.setFileName(file.getFilename());
			emailDetails.setFromEmailId(String.valueOf(file.getMetadata().get("uploadedMail")));
			emailDetails.setRecipientEmailId(String.valueOf(file.getMetadata().get("recipientEmailId")));
			emailDetails.setUploadedDate(file.getUploadDate());
			emailDetails.setObjectId(file.getObjectId().toString());
			emailDetailsList.add(emailDetails);

		}

		return emailDetailsList;

	}

}

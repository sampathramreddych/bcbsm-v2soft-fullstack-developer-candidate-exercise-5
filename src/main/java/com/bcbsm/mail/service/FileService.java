package com.bcbsm.mail.service;

import com.bcbsm.mail.model.EmailDetails;
import com.bcbsm.mail.model.FileDocument;
import com.mongodb.client.gridfs.GridFSFindIterable;
import com.mongodb.client.gridfs.model.GridFSFile;



import org.apache.commons.io.IOUtils;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Service
public class FileService {

    @Autowired
    private GridFsTemplate template;





}

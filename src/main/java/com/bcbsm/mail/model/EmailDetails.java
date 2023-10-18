package com.bcbsm.mail.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@Data
public class EmailDetails {

    private String fromEmailId;
    private String recipientEmailId;
    private String fileName;
    private String uploadUser;
    private Date uploadedDate;
    private String objectId;
    private byte[] file;


    public EmailDetails(String fromEmailId, String recipientEmailId, String fileName, String uploadUser, Date uploadedDate, byte[] file, String objectId) {
        this.fromEmailId = fromEmailId;
        this.recipientEmailId = recipientEmailId;
        this.fileName = fileName;
        this.uploadUser = uploadUser;
        this.uploadedDate = uploadedDate;
        this.file = file;
        this.objectId = objectId;
    }
}

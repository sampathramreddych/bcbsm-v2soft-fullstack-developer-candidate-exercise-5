package com.bcbsm.mail.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.bcbsm.mail.security.BcbsUserDetails;

public interface UserRepository extends MongoRepository<BcbsUserDetails, ObjectId> {

	public BcbsUserDetails findUserByUsername(String username);

}

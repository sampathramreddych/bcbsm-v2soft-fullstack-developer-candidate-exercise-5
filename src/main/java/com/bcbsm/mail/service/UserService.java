package com.bcbsm.mail.service;


import com.bcbsm.mail.model.UserModel;

public interface UserService {

	UserModel getUser(String name);

	String addUser(UserModel user);

}

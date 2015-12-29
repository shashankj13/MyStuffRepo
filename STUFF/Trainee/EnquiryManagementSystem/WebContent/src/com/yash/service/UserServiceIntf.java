package com.yash.service;

import java.util.ArrayList;

import com.yash.domain.Enquiry;
import com.yash.domain.User;

public interface UserServiceIntf {

	void userRegistration(User user);
	
	void userDelete(User user, String userName);
	boolean userAuthentication(String userName);
	User userId(String userName);
	ArrayList<Enquiry> viewEnquiry(int userId);
	
}

package com.yash.service;

import java.util.ArrayList;

import com.yash.domain.Enquiry;

public interface EnquiryServiceIntf {
	
	void addEnquiry(Enquiry enquiry);
	
	ArrayList<Enquiry> viewEnquiry(int userId);
	
	void deleteAllEnquiry(int userId);
	
	void deleteEnquiry(int enquiryId);

}

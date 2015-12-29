package com.yash.service;

import java.util.ArrayList;

import com.yash.domain.Enquiry;
import com.yash.util.DButil;

public class EnquiryServiceImpl implements EnquiryServiceIntf{

	@Override
	public void addEnquiry(Enquiry enquiry) {
		
		String query = "INSERT INTO ENQUIRY(NAME, USERID, EMAIL,CONTACT,COURSE) VALUES (?,?,?,?,?)";
		
		DButil.insertEnquiry(query, enquiry);
		
	}

	@Override
	public ArrayList<Enquiry> viewEnquiry(int userId) {
		
		String query = "SELECT * FROM ENQUIRY WHERE USERID=?";
		ArrayList<Enquiry> enquiries= DButil.fetchEnquiry(query,userId);
		
		return enquiries;
		
		
	}

	@Override
	public void deleteAllEnquiry(int userId) {
		
		String query = "DELETE FROM ENQUIRY WHERE USERID=?";
		
		DButil.deleteEnquiryAll(query, userId);
	}

	@Override
	public void deleteEnquiry(int enquiryId) {
		
		String query = "DELETE FROM ENQUIRY WHERE ENQUIRYID=?";
		
		DButil.deleteEnquiry(query, enquiryId);
		
	}

}

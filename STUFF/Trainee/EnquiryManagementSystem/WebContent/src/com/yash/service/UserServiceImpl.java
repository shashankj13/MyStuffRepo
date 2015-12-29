package com.yash.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import com.yash.domain.Enquiry;
import com.yash.domain.User;
import com.yash.util.ConnectionProvider;
import com.yash.util.DButil;

public class UserServiceImpl implements UserServiceIntf{

	@Override
	public void userRegistration(User user) {
			
		String query = "INSERT INTO USER(NAME,EMAIL,TYPE,STATUS,USERNAME,PASSWORD) VALUES(?,?,?,?,?,?)";
			
		DButil.insert(query, user);
	}

	

	@Override
	public void userDelete(User user , String userName) {
		
		String query = "DELETE FROM USER WHERE USERNAME=?";
		DButil.delete(query,  userName);
		
		
	}



	@Override
	public boolean userAuthentication(String userName) {
		
		String query = "SELECT USERNAME FROM USER WHERE USERNAME=?";
		boolean result = DButil.check(query, userName);
		
		if(result==true){
			
			return true;
			
		}
		return false;
	}



	@Override
	public User userId(String userName) {
		String query = "SELECT * FROM USER WHERE USERNAME=?";
		User user = DButil.fetchId(query, userName);
		return user;
		
		
	}
	
	
	@Override
	public ArrayList<Enquiry> viewEnquiry(int userId) {
		
		String query = "SELECT * FROM ENQUIRY WHERE USERID=? ";
		ArrayList<Enquiry> enquiries= DButil.fetchEnquiry(query,userId );
		
		return enquiries;
		
		
	}



	
}

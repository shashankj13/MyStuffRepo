package com.yash.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.yash.domain.Enquiry;
import com.yash.domain.User;

public class DButil {
	
	static public Connection connectDB(){
		
		Connection connection = ConnectionProvider.getConnection();
		return connection;
	}

	static public void disconnectDB(Connection connection) throws SQLException{
		
		connection.close();
		
	}
	
	 public static void insert(String query , User user){
		Connection connection=connectDB();
		
		try {
			System.out.println(connection);
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getEmail());
			preparedStatement.setInt(3, user.getType());
			preparedStatement.setInt(4, user.getStatus());
			preparedStatement.setString(5,  user.getUserName());
			preparedStatement.setString(6, user.getPassword());
			preparedStatement.executeUpdate();
			disconnectDB(connection);
		} catch (Exception e) {

		}

				
	}
	 public static void delete(String query , String userName){
		Connection connection=connectDB();
		
		try {
			System.out.println(connection);
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, userName);
			preparedStatement.executeUpdate();
			
		} catch (Exception e) {

		}

				
	}
	 
	 public static boolean check(String query , String userName){
			Connection connection=connectDB();
			
			try {
				PreparedStatement preparedStatement = connection.prepareStatement(query);
				preparedStatement.setString(1, userName);
				ResultSet resultSet = preparedStatement.executeQuery();
				while(resultSet.next()){
					String name = resultSet.getString("USERNAME");
					System.out.println(name);
					if(name.equalsIgnoreCase(userName)){
						return true;
					}
				}
				disconnectDB(connection);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;

					
		}
	 public static User fetchId(String query, String userName ){
			Connection connection=connectDB();
			User user = new User();
			try {
				PreparedStatement preparedStatement = connection.prepareStatement(query);
				preparedStatement.setString(1, userName);
				ResultSet resultSet = preparedStatement.executeQuery();
				while(resultSet.next()){
					String userName1 = resultSet.getString("USERNAME");
					System.out.println(userName1);
					if(userName1.equalsIgnoreCase(userName)){
						int userId = resultSet.getInt("USERID");
						String name = resultSet.getString("NAME");
						user.setUserId(userId);
						user.setName(name);
						return user;
					}
				}
				disconnectDB(connection);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;

					
		}
	 
	 public static void insertEnquiry(String query , Enquiry enquiry){
			Connection connection=connectDB();
			
			try {
				System.out.println(connection);
				PreparedStatement preparedStatement = connection.prepareStatement(query);
				preparedStatement.setString(1, enquiry.getName());
				preparedStatement.setInt(2, enquiry.getUserId());
				preparedStatement.setString(3, enquiry.getEmail());
				preparedStatement.setInt(4, enquiry.getContact());
				preparedStatement.setString(5, enquiry.getCourse());
				preparedStatement.executeUpdate();
				disconnectDB(connection);
			} catch (Exception e) {

			}

					
		}
	 
	 
	 public static ArrayList<Enquiry> fetchEnquiry(String query, int userId){
		 
			Connection connection=connectDB();
			try{
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			ArrayList<Enquiry> arrayList = new ArrayList<Enquiry>();
			preparedStatement.setInt(1, userId);
			preparedStatement.execute();
			ResultSet resultSet = preparedStatement.getResultSet();
			while (resultSet.next()) {
				Enquiry enquiry = new Enquiry();
				int enquiryId = resultSet.getInt("ENQUIRYID");
				String name = resultSet.getString("NAME");
				String email = resultSet.getString("EMAIL");
				int userId1 = resultSet.getInt("USERID");
				int contact = resultSet.getInt("CONTACT");
				String course = resultSet.getString("COURSE");
				enquiry.setEnquiryId(enquiryId);
				enquiry.setName(name);
				enquiry.setEmail(email);
				enquiry.setUserId(userId1);
				enquiry.setContact(contact);
				enquiry.setCourse(course);
				arrayList.add(enquiry);
				
			}
			disconnectDB(connection);
			return arrayList;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return null;		 
	 }
	 
	 
	 public static void deleteEnquiryAll(String query,int userId){
		 Connection connection=connectDB();
		 
		 try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, userId);
			preparedStatement.execute();
			disconnectDB(connection);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 
	 }

	 public static void deleteEnquiry(String query,int enquiryId){
		 Connection connection=connectDB();
		 
		 try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, enquiryId);
			preparedStatement.execute();
			disconnectDB(connection);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 
	 }
}

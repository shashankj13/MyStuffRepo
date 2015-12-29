package com.org.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.org.domain.Customer;
import com.org.util.ConnectionProvider;



public class CustomerSignupDao {
	
	
	public static int setMaxId(){
		Connection connection = ConnectionProvider.getConnection();
		String query = "SELECT MAX(ID) FROM CUSTOMER";
		Statement statement;
		int id=0;
		try {
			statement = connection.createStatement();
			ResultSet resultset = statement.executeQuery(query);
			while(resultset.next()){
				
				id = resultset.getInt(1);
			}
			return ++id;
		} catch (SQLException e) {
			
			e.printStackTrace();
			return 0;
		}
		
		
		
		
	}
	
	public static  void insertIntoCustomer(Customer customer){
		Connection connection = ConnectionProvider.getConnection();
		String query = "INSERT INTO CUSTOMER VALUES(?,?,?,?,?)";
		
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1,customer.getId());
			preparedStatement.setString(2,customer.getName());
			preparedStatement.setString(3,customer.getCity());
			preparedStatement.setInt(4,customer.getMobileNumber());
			preparedStatement.setString(5,customer.getPassword());
			preparedStatement.executeUpdate();
			AccountDao.addAccountIn(customer);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}

}

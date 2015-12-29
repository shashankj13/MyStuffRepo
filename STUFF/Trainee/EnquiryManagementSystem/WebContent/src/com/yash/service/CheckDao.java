package com.yash.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.yash.util.ConnectionProvider;

public class CheckDao {

	public boolean check(String userName){
		Connection connection = ConnectionProvider.getConnection();
		String query = "SELECT USERNAME FROM USER WHERE USERNAME=?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, userName);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				String name = resultSet.getString(1);
				System.out.println(name);
				
			
					if(name.equalsIgnoreCase(userName)){
						
						
						return true;
					}
					
					
					
					
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
		
		
	}

}

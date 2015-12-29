package com.yash.curdcdi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.yash.curdcdi.util.CustomerUtilImpl;

public class CustomerDaoImpl implements CustomerDao {
	
	@Override
	public ResultSet select(String query) {
		ResultSet resultset = null;
		
		PreparedStatement preparedStatement;
		try {
			Connection connection=  CustomerUtilImpl.connect();
			preparedStatement = connection.prepareStatement(query);
			 resultset = preparedStatement.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return resultset;

	}

	@Override
	public void update(String query) {
		try {
			System.out.println(query);
			Connection connection=  CustomerUtilImpl.connect();
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}

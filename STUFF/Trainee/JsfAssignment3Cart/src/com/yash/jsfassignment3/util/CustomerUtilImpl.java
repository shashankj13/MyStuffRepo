package com.yash.jsfassignment3.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CustomerUtilImpl {

	private static Connection connection;
	static String url = "jdbc:mysql://localhost:3306/jsfdb";
	static String username = "root";
	static String password = "root";

	
	public static Connection connect() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(url, username, password);
			return connection;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return connection;

		}

	}

	
	public static void disconnect() {
		try {
			Connection connection = connect();
			connection.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}
	

	

}

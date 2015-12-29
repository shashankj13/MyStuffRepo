package com.yash.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {

	static private Connection connection;
	static String url = "jdbc:mysql://localhost:3306/ems";
	static String user = "root";
	static String password = "root";

	public static Connection getConnection() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(url, user, password);
			return connection;
		} catch (Exception e) {
			System.out.println("Exception is :==  " + e.getMessage());
			return connection;
		}

	}
	

	

}

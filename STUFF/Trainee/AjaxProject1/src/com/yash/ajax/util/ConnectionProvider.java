package com.yash.ajax.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {
	private static Connection connection;
	static String url = "jdbc:mysql://localhost:3306/employees";
	static String username = "root";
	static String password = "root";

	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(url, username, password);
			return connection;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return connection;

		}
	}

	public static void close() {
		try {
			connection.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

}

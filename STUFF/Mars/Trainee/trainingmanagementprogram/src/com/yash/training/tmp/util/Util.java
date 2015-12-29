package com.yash.training.tmp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Util {
	private static Connection connection;
	static String url = "jdbc:mysql://localhost:3306/trainingmanagement";
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

	public static ResultSet select(String query) {
		ResultSet resultset = null;

		PreparedStatement preparedStatement;
		try {
			Connection connection = Util.connect();
			preparedStatement = connection.prepareStatement(query);
			resultset = preparedStatement.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return resultset;

	}

	public static void update(String query) {
		try {
			System.out.println(query);
			Connection connection = Util.connect();
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

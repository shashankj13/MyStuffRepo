package com.yash.emp.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbUtil {
	static String url = "jdbc:mysql://localhost:3306/enquirymanagementsystem";
	static String username = "root";
	static String password = "root";
	static Connection connection;
	
	public static Connection connect(){
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(url, username, password);
			return connection;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return connection;

		}
	}
	public static void disconnect(){
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static ResultSet select(String sql){
		return null;}
	
	public static void update(String sql){}
}

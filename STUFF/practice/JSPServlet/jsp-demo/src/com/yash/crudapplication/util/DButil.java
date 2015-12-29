package com.yash.crudapplication.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class DButil {
	
	
    static String driverClassName="com.mysql.jdbc.Driver";
    static String url="jdbc:mysql://localhost/test";
    static String userName="root";
    static String password="root";
    static Connection connection;
    
    public static Connection connectDB()throws Exception{
    	
    	
        Class.forName(driverClassName);
        connection=DriverManager.getConnection(url, userName, password);
        return connection;        
    }
    
    
    public static void update(String sql) throws Exception{
    	 connection = connectDB();
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        preparedStatement.executeUpdate();
        disconnectDB();
    }
   
    public static ResultSet select(String sql){
        try{
        	connection = connectDB();
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        ResultSet resultSet=preparedStatement.executeQuery();
        return resultSet;
        }
        catch(Exception ex){
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }
    
    public static void disconnectDB() throws Exception{
        connection.close();
    }

}

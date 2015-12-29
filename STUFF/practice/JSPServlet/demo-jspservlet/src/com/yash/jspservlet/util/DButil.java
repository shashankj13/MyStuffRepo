package com.yash.jspservlet.util;

import java.sql.Connection;
import java.sql.DriverManager;

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
    
   
    
    public static void disconnectDB() throws Exception{
        connection.close();
    }

}

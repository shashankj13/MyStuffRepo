package com.yash.listener;


import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		

	}

	@Override
	public void contextInitialized(ServletContextEvent contextEvent) {
		FileReader reader;
		try {
			
			String path = contextEvent.getServletContext().getInitParameter("FILE");
			String url = contextEvent.getServletContext().getRealPath(path);
			reader = new FileReader(url);
			Properties properties=new Properties();  
		    properties.load(reader);   
		    contextEvent.getServletContext().setAttribute("properties", properties);

			String driver = contextEvent.getServletContext().getInitParameter("driver");
			
			String url1 = contextEvent.getServletContext().getInitParameter("url");
			String username = contextEvent.getServletContext().getInitParameter("username");
			String pass = contextEvent.getServletContext().getInitParameter("password");
			
			Class.forName(driver);
			Connection conn= DriverManager.getConnection(url1, username, pass);
			System.out.println(conn);
			contextEvent.getServletContext().setAttribute("connection", conn);
			System.out.println(conn);
		} catch (Exception e) {
			e.printStackTrace();	
		}  
	
	    

	}

}

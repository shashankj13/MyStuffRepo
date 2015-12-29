package com.yash.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;




public class FilterAuthenticate implements Filter {

	public void destroy() {
		
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("AUTHENTICATION FILTER STARTED");
		
		 try {
			  Class.forName("com.mysql.jdbc.Driver");
			  Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
			  Statement stmt = connection.createStatement();
			  ResultSet rs = stmt.executeQuery("SELECT ID FROM CUSTOMER1 WHERE ID = " + (Integer.parseInt(request.getParameter("val1"))));
			  while(rs.next())
			  {
				  if (rs.getInt(1)==(Integer.parseInt(request.getParameter("val1")))) {
					  request.setAttribute("ID", rs.getInt(1));
					  
					  chain.doFilter(request, response);
					  System.out.println("AUTHENTICATION FILTER STOPPED");
				  }
				  
					  
				  
			
			  } 
			  PrintWriter out = response.getWriter();
			  out.println("WRONG USER ID PASSSOWRD");
		
		 }
		 catch(Exception e ){}
	}
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}

package com.yash.itservicedesk.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yash.itservicedesk.pojo.EmpDetails;

@WebServlet("/ResponseServlet")
public class ResponseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("SET");
		
		EmpDetails emp = TechSupportServlet.SendEmpRef();
		String email = emp.getEmail();
		String desc = emp.getDesc();
		String os = emp.getOs();
		String software = emp.getSoftware();
		
		try{
			System.out.println("RECEIVED");
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/itservicedesk","root","root");
			PreparedStatement stmt = conn.prepareStatement("INSERT INTO EMPLOYEEDETAILS VALUES(?,?,?,?)");
			stmt.setString(1,email );
			stmt.setString(2, software);
			stmt.setString(3, os);
			stmt.setString(4, desc);
			stmt.executeUpdate();
			System.out.println("STORED");
		}
		catch(Exception e){}
	}

}

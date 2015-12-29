package com.yash.training.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/EmployeeAction")
public class EmployeeAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PrintWriter out;
    
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		out = response.getWriter();
		response.setContentType("text/html");
		String name = request.getParameter("empName");
		String sal = request.getParameter("empSal");
		int empSal= Integer.parseInt(sal);
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","root");
			String query = "insert into employee(name,salary) values('"+name+"' ,'"+empSal+"')";
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(query);
			out.println("ADDED SUCCESSFULLY");
			out.println("<a href = 'ers' > SHOW TABLE </a>");
			
		}
		catch(Exception e) {System.out.println("ERROR INSERTs");}
		
	}

}

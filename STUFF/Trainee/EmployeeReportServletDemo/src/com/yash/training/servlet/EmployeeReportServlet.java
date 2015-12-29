package com.yash.training.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ers")
public class EmployeeReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("");
		out.println("<html>");
		out.println("<head>");
		out.println("<title> SERVLET </title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1> EMPLOYEE TABLE </h1>");
		out.println("<table border='1'>");
		out.println("<tr>");
		out.println("<th> ID </th><th> NAME </th><th> SALARY </th> ");
		out.println("</tr>");
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","root");
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from employee");
			
			
		
			while(rs.next()){
				out.println("<tr>");
				out.println("<td>" + rs.getInt(1)+ "</td>" + "<td>" + rs.getString(2)+ "</td>" + "<td>" + rs.getInt(3)+ "</td>");
				out.println("<tr>");
			}
		}
		catch(Exception e){System.out.println("ERROR");}
		
		out.println("</table>");
		out.println("<a href = 'Employeeform.html'>  ADD NEW EMPLOYEE </a>");
		out.println("</body>");
		out.println("</html>");
		
	}

}

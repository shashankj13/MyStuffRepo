package com.yash.itservicedesk.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.yash.itservicedesk.pojo.EmpDetails;


@WebServlet("/tss")
public class TechSupportServlet extends HttpServlet {
	static int count =0;
	static EmpDetails empdetails = new EmpDetails();
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter();
		String email = request.getParameter("email");
		String os = request.getParameter("os");
		String desc = request.getParameter("desc");
		String software = request.getParameter("soft");
		
		
		
		empdetails.setDesc(desc);
		empdetails.setEmail(email);
		empdetails.setOs(os);
		empdetails.setSoftware(software);
		
		
		
		
		try{ 
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/itservicedesk","root","root");
			Statement stmt = conn.createStatement();
			java.sql.ResultSet rs = stmt.executeQuery("SELECT EMAIL FROM REGISTER");
			
			while(rs.next()){
				
				if(rs.getString(1).equals(email)){
					System.out.println("wertgyh");
					ServletContext application = getServletContext();
					RequestDispatcher rd = application.getRequestDispatcher("/ResponseServlet");
					rd.forward(request, response);
					count=1;
					System.out.println("FORWARDED RESPONSE");
					
				}
					
				
			}
			if(count==0){
				System.out.println("COUNT = 0 ");
				ServletContext application = getServletContext();
				RequestDispatcher rd = application.getRequestDispatcher("/RegisterServlet");
				rd.forward(request, response);
				System.out.println("FORWARDED REGISTER");
				
			}
			
			
		}
		catch(Exception e){System.out.println("ERROR");}
		
	}
	public static EmpDetails SendEmpRef(){
		return empdetails;
	}
	

}

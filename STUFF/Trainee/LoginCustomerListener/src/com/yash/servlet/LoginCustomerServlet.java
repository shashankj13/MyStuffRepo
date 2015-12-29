package com.yash.servlet;

import java.io.IOException;


import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static int count=1;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			PrintWriter out = response.getWriter();
			out.println(request.getAttribute("ID"));
			
		
		
		 
		}      
		
		
	
}

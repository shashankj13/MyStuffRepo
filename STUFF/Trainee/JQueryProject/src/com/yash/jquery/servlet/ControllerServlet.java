package com.yash.jquery.servlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ControllerServlet")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 Enumeration<?> input=request.getParameterNames();
		 PrintWriter out=response.getWriter();
		 while(input.hasMoreElements()){
			 int count=0;
			 out.print(count);
			 String param=(String) input.nextElement();
			 out.print(param+":");
			 out.println(request.getParameter(param));
		 }
	}

	
}


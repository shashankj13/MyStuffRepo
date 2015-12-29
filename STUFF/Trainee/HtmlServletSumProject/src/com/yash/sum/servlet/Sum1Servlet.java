package com.yash.sum.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Sum1Servlet")
public class Sum1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				 
				String v1= request.getParameter("value1");
				String v2 =request.getParameter("value2");
				int value1 = Integer.parseInt(v1);
				int value2 = Integer.parseInt(v2);
				int sum =value1+value2;
				HttpSession session = request.getSession();
				session.setAttribute("sum",sum );
				getServletContext().getRequestDispatcher("/Sum2Servlet").forward(request, response);
	}
}

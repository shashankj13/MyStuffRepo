package com.yash.cookie.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/NewsControllerServlet")
public class NewsControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	PrintWriter out = response.getWriter();
		out.println("REQ RECEIVED");
	
		Cookie [] cookies = request.getCookies();
		
					
		
		if(cookies!=null){
			for(Cookie cookie : cookies)
				if(cookie.getName().equals("cnews")){
					response.sendRedirect(cookie.getValue()+".html");
					//getServletContext().getRequestDispatcher("/"+cookie.getValue()+".html").forward(request, response);
					return;
				}
			
		}
		ServletContext application = getServletContext();
		application.getRequestDispatcher("/NewsHome.html").forward(request, response);
				
	}

}

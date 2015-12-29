package com.yash.dp.singleton;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/TestSingleton")
public class TestSingleton extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	@EJB
	SingletonSessionBeanLocal ssb;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		ssb.increment();
		out.print(ssb.getNumber());
	}

}

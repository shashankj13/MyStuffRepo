package com.yash.jquery.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ShowServlet")
public class ShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Enumeration<?> list = request.getParameterNames();
		PrintWriter out = response.getWriter();
		while (list.hasMoreElements()) {
			String str = (String) list.nextElement();
			out.println(request.getParameter(str));
		}
	}

}

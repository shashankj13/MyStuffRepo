package com.yash.cookie.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/CookieServlet")
public class SetCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		Cookie c1 = new Cookie("c1name","c1value");
		Cookie c2 = new Cookie("c2name","c2value");
		Cookie c3 = new Cookie("c3name","c3value");
		response.addCookie(c1);
		response.addCookie(c2);
		response.addCookie(c3);
		out.print("ADDED");
	}

}

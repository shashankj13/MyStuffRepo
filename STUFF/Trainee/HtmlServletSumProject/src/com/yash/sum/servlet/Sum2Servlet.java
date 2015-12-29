package com.yash.sum.servlet;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Sum2Servlet")
public class Sum2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");  
		
		out.println("<html>");
		out.println("<body bgcolor='lightblue'>");
		 
		HttpSession session = request.getSession(false);
		int sum = (int) session.getAttribute("sum");
		int finalSum=0;    
		
		if(request.getParameter("value3")!=null){
			finalSum=Integer.parseInt(request.getParameter("value3"));
			sum=sum + finalSum;
			session.setAttribute("sum", sum);
		}
		
		else{
		session.setAttribute("sum", sum);
		}
		
		 
		out.print("<form method='get' action='Sum2Servlet'>");
		out.println("<table border='1'>");
		
		out.println("<tr>");
		out.println("<td colspan='2'>Sum is :  " +sum);
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td> Enter Value 3 : </td> ");
		out.println("<td><input type='text' name='value3'></td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td colspan='2' align='center'> <input type='submit' value='SUM AGAIN' name='sum'> </td>");
		out.println("</tr>");
		out.println("</table>");
		out.print("<form>");
		out.println("</body>");
		out.println("</html>");
	}

}

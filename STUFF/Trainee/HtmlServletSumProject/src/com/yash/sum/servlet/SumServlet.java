package com.yash.sum.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/SumServlet")
public class SumServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		PrintWriter out=response.getWriter();
		String v1 = request.getParameter("value1");
		String v2 = request.getParameter("value2");
		int value1=Integer.parseInt(v1);
		int value2=Integer.parseInt(v2);
		
		int result=value1 + value2;
		String resultString = String.valueOf(result);
		request.setAttribute(resultString, request);
		
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body bgcolor='lightblue'>");
		out.println("<form action='SumAgainServlet' method='get'>");
		out.println("<table border='1'>");
		
		out.println("<tr>");
		out.println("<td>");
		out.println("Sum is :");
		out.println("</td>");
		out.println("<td>");
		out.println("<p name='value3'>");	
		out.println(+result);
		out.println("<p>");
		out.println("<td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td>");
		out.println("Enter Third No:");
		out.println("</td>");
		out.println("<td>");
		out.println("<input type='text' name='value4'>");
		out.println("<td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td colspan='2' align='center'>");
		out.println("<input type='submit' value='OK'>");
		out.println("</td>");
		out.println("</tr>");
		
		out.println("</table>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
		
		
		
		getServletContext().getRequestDispatcher("/SumAgainServlet").include(request, response);
		
	}

}

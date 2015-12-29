package com.yash.servlet;


import java.io.IOException;
import java.io.PrintWriter;





import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/ViewCustomerServlet")
public class ViewCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		Properties properties = (Properties) getServletContext().getAttribute("properties");
		String id = properties.getProperty("customer.id");  
	    String pass = properties.getProperty("customer.pass");
		response.setContentType("text/html");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>");
		out.println("VIEW CUSTOMER");
		out.println("</title>");
		out.println("</head>");
		out.println("<body bgcolor='lightblue'>");
		
		out.println("<form action='lcs.do' method='get'>");
		out.println("<table>");
		
		out.println("<tr>");
			out.println("<td>");
				out.println(id);
			out.println("</td>");
			out.println("<td>");
				out.println("<input type='text' name='val1'>");
			out.println("</td>");
		out.println("</tr>");
		
		out.println("<tr>");
			out.println("<td>");
				out.println(pass);
			out.println("</td>");
			out.println("<td>");
				out.println("<input type='text' name='val2'>");
			out.println("</td>");
		out.println("</tr>");
		
		out.println("<tr>");
			out.println("<td colspan = '2' align ='center'>");
				out.println("<input type='submit' value='submit'>");
			out.println("</td>");
		out.println("</tr>");
		
		out.println("</table>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
		
		
	}

}

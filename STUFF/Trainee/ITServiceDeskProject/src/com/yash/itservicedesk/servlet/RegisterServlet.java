package com.yash.itservicedesk.servlet;

import java.io.IOException;
import java.io.PrintWriter;
/*import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;*/



import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("REGISTER CAUGHT");
		String email = request.getParameter("email");
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("");
		
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title> REGISTER  </title>");
		out.println("</head>");
		out.println("<body bgcolor='lightblue'>");
		out.println("<h1> REGISTER DETAILS</h1>");
		out.println("<form method='post' action='/RegisterSubmitServlet'>" );
		out.println("<table border='1'>");
		
		out.println("<tr>");
		out.println("<td>EMAIL ID :</td>");
		out.println("<td>" + email + "</td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td> FIRST NAME:</td>");
		out.println("<td> <input type='text' name='fname'></td>");
		out.println("</tr>"); 
		
		out.println("<tr>");
		out.println("<td> LAST NAME:</td>");
		out.println("<td> <input type='text' name='lname'></td>");
		out.println("</tr>"); 
		
		out.println("<tr>");
		out.println("<td>Mobile No :</td>");
		out.println("<td> <input type='text' name='mob'></td>");
		out.println("</tr>"); 
		
		out.println("<tr>");
		out.println("<td> <input type='submit' value='SUBMIT'></td>");
		out.println("</tr>"); 
		out.println("</form>");
		out.println("</table>");
		out.println("</body>");		
		out.println("</html>");
		
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String mobNumber = request.getParameter("mob");
		
		/*ServletContext application = getServletContext();
		RequestDispatcher rd = application.getRequestDispatcher("/RegisterSubmitServlet");
		rd.forward(request, response);*/
		
		
		
		/*try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","root");
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from employee");
			
			
		
			while(rs.next()){
				out.println("<tr>");
				out.println("<td>" + rs.getInt(1)+ "</td>" + "<td>" + rs.getString(2)+ "</td>" + "<td>" + rs.getInt(3)+ "</td>");
				out.println("<tr>");
			}
		}
		catch(Exception e){System.out.println("ERROR");}
		
		out.println("</table>");
		out.println("<a href = 'Employeeform.html'>  ADD NEW EMPLOYEE </a>");
		out.println("</body>");
		out.println("</html>");
		
	}*/
	}
	
}

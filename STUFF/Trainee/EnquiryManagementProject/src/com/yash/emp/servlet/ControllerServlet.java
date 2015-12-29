package com.yash.emp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yash.emp.domain.Enquiry;


@WebServlet("/ControllerServlet")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action = request.getParameter("action");
		System.out.println(action);
		if(action.equalsIgnoreCase("ADD_ENQUIRY")){
			String value = "add";
			request.getSession().setAttribute("value", value);
			request.getRequestDispatcher("/EnquiryForm.jsp").forward(request, response);
			
		}else if(action.equalsIgnoreCase("DELETE_ALLENQUIRY")){
			String value ="deleteAll";
			request.getSession().setAttribute("value", value);
			request.getRequestDispatcher("/EnquiryActionServlet").forward(request, response);
		}else if(action.equalsIgnoreCase("LogOut")){
			String value="LogOut Successfully";
			request.getSession().setAttribute("value", value);
			request.getRequestDispatcher("/LoginForm.jsp").forward(request, response);
			
		}else if(action.equalsIgnoreCase("Delete")){
			Enquiry enquiry = new Enquiry();
			int enquiryId=Integer.parseInt(request.getParameter("delete"));
			System.out.println(enquiryId);
			String value = "delete";
			request.getSession().setAttribute("value", value);
			request.getSession().setAttribute("enquiryId", enquiryId);
			request.getRequestDispatcher("/EnquiryActionServlet").forward(request, response);
			
			
		}
	
	}
	

}

package com.yash.ems.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yash.ems.dao.Dao;
import com.yash.ems.domain.Enquiry;


@WebServlet("/EnquiryServlet")
public class EnquiryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Enquiry enquiry = new Enquiry();
		enquiry.setName(request.getParameter("name"));
		enquiry.setEmail(request.getParameter("email"));
		enquiry.setContact(Integer.parseInt(request.getParameter("contact")));
		Dao.insertEnquiry(enquiry);
		
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}

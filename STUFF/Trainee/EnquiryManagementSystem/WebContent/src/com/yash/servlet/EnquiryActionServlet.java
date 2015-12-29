package com.yash.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yash.domain.Enquiry;
import com.yash.service.EnquiryServiceImpl;
import com.yash.service.EnquiryServiceIntf;


@WebServlet("/EnquiryActionServlet")
public class EnquiryActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		EnquiryServiceIntf enquiryServiceIntf =  new EnquiryServiceImpl();
		String value= (String) request.getSession().getAttribute("value");
		
		if(value.equalsIgnoreCase("add")){
			int userId = (int) request.getSession().getAttribute("userId");
			
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		int contact = Integer.parseInt(request.getParameter("contact"));
		String[] course = request.getParameterValues("course");
		StringBuffer coursebuffer = new StringBuffer();
			for (int i = 0; i < course.length; i++) {
				if (i != course.length - 1)
					coursebuffer.append(course[i] + ", ");
				else
					coursebuffer.append(course[i] + ".");
			}
			Enquiry enquiry = new Enquiry();

		enquiry.setName(name);
		enquiry.setUserId(userId);
		enquiry.setEmail(email);
		enquiry.setContact(contact);
		enquiry.setCourse(coursebuffer.toString());
		
		enquiryServiceIntf.addEnquiry(enquiry);
		ArrayList<Enquiry> list =  enquiryServiceIntf.viewEnquiry(userId);
		System.out.println(list);
		request.setAttribute("list", list);
		}else if(value.equalsIgnoreCase("deleteAll")){
			int userId = (int) request.getSession().getAttribute("userId");

			enquiryServiceIntf.deleteAllEnquiry(userId);
			
		}else if(value.equalsIgnoreCase("delete")){
			int userId = (int) request.getSession().getAttribute("userId");
			
			int enquiryId = (int) request.getSession().getAttribute("enquiryId");
			System.out.println(enquiryId);
			enquiryServiceIntf.deleteEnquiry(enquiryId);
			
			ArrayList<Enquiry> list =  enquiryServiceIntf.viewEnquiry(userId);
			System.out.println(list);
			request.setAttribute("list", list);
			
			
		}
		
		
		request.getRequestDispatcher("/Display.jsp").forward(request, response);
		
		
	}

}

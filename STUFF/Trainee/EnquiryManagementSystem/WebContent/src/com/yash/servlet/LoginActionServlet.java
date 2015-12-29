package com.yash.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yash.domain.Enquiry;
import com.yash.domain.User;
import com.yash.service.CheckDao;
import com.yash.service.UserServiceImpl;
import com.yash.service.UserServiceIntf;


@WebServlet("/LoginActionServlet")
public class LoginActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		CheckDao checkDao =  new CheckDao();
		UserServiceIntf userServiceIntf = new UserServiceImpl();
		boolean result = userServiceIntf.userAuthentication(userName);
		User user = userServiceIntf.userId(userName);
		if(result==true){
			int id = user.getUserId();
			request.setAttribute("user", user);
			request.getSession().setAttribute("userId", user.getUserId());
			ArrayList<Enquiry> list =  userServiceIntf.viewEnquiry(id);
			System.out.println(list);
			request.setAttribute("list", list);
			
			RequestDispatcher dispatcher =request.getRequestDispatcher("/Display.jsp");
			dispatcher.forward(request, response);
		}
		else{
			RequestDispatcher dispatcher = request.getRequestDispatcher("/Registration.jsp");
			dispatcher.forward(request, response);
			
			
		}
		
	}

}

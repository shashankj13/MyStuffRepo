package com.yash.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yash.domain.User;
import com.yash.service.UserServiceImpl;
import com.yash.service.UserServiceIntf;


@WebServlet("/RegistrationActionServlet")
public class RegistrationActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String name =  request.getParameter("name");
		String email =  request.getParameter("email");
		int type = Integer.parseInt(request.getParameter("type"));
		int  status = Integer.parseInt(request.getParameter("status"));
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		
		User user = new User();
		user.setName(name);
		user.setEmail(email);
		user.setType(type);
		user.setStatus(status);
		user.setUserName(userName);
		user.setPassword(password);
		
		UserServiceIntf userServiceIntf = new UserServiceImpl();
		userServiceIntf.userRegistration(user);
		String info = "Registration Successfully";
		request.setAttribute("success", info);
		request.getRequestDispatcher("/LoginForm.jsp").forward(request, response);
		
		
	}

}

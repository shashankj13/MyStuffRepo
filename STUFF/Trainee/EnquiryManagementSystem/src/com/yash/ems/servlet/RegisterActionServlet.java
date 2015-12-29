package com.yash.ems.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yash.ems.dao.Dao;
import com.yash.ems.domain.User;

@WebServlet("/RegisterActionServlet")
public class RegisterActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		User user = new User();

		user.setName(request.getParameter("name"));
		user.setEmail(request.getParameter("email"));
		user.setType(Integer.parseInt(request.getParameter("type")));
		user.setStatus(Integer.parseInt(request.getParameter("status")));
		user.setUsername((String) request.getParameter("username"));
		user.setPassword((String) request.getParameter("password"));
		Dao.insertuser(user);
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}

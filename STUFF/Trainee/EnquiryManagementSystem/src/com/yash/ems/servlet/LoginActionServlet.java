package com.yash.ems.servlet;

import java.util.List;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.yash.ems.domain.Enquiry;
import com.yash.ems.dao.Dao;
import com.yash.ems.domain.User;

@WebServlet("/LoginActionServlet")
public class LoginActionServlet extends HttpServlet {
		List<Enquiry> list;
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		User user = new User();
		user.setUsername((String) request.getParameter("username"));
		user.setPassword((String) request.getParameter("password"));
		int id = Dao.fetchUser(user);
		list = Dao.displayEnquiry(id);
		
		request.setAttribute("list", list);
		request.getRequestDispatcher("listener.jsp").forward(request, response);

	}

}

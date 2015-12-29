package com.yash.servlet;

import java.io.IOException;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yash.dao.CustomerDao;
import com.yash.domain.Customer;

@WebServlet("/ControllerServlet")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// PrintWriter out = response.getWriter();

		String id = request.getParameter("val");
		if (id == "") {
			List<Customer> list = CustomerDao.showAllCustomer();
			request.setAttribute("customer", list);
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("CustomerView.jsp");
			dispatcher.forward(request, response);
		}
		if (id != "") {
			int id1 = Integer.parseInt(id);
			List<Customer> list = CustomerDao.showCustomer(id1);
			request.setAttribute("customer", list);
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("CustomerView.jsp");
			dispatcher.forward(request, response);
		}

	}

}

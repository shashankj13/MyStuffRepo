package com.yash.jspservlet.sevlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.yash.jspservlet.domain.Employee;
import com.yash.jspservlet.service.EmployeeService;

@WebServlet("/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String value = request.getParameter("a");
		System.out.println(value);
		EmployeeService employeeService = new EmployeeService();

		if (value.equalsIgnoreCase("ALL")) {
			List<Employee> list = employeeService.fetchAllEmployee();
			HttpSession session = request.getSession(true);
			session.setAttribute("listemp", list);
			request.getRequestDispatcher("seeallemployee.jsp").forward(request, response);
		}

		if (value.equalsIgnoreCase("Submit")) {
			String name = request.getParameter("name");
			String city = request.getParameter("city");
			employeeService.addEmployee(name, city);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}

		if (value.equalsIgnoreCase("MODIFY")) {
			int id = Integer.parseInt(request.getParameter("id"));
			String name = request.getParameter("name");
			String city = request.getParameter("city");
			List<Employee> list = employeeService.updateEmployee(name, city, id);
			HttpSession session = request.getSession(true);
			session.setAttribute("listemp", list);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}

		if (value.equalsIgnoreCase("OK")) {
			int id = Integer.parseInt(request.getParameter("id"));
			employeeService.delEmployee(id);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}

		if (value.equalsIgnoreCase("ADD")) {
			request.getRequestDispatcher("addemployee.jsp").forward(request, response);
		}

		if (value.equalsIgnoreCase("DELETE")) {
			request.getRequestDispatcher("deleteemployee.jsp").forward(request, response);
		}

		if (value.equalsIgnoreCase("UPDATE")) {
			request.getRequestDispatcher("updateemployee.jsp").forward(request, response);

		}
	}
}
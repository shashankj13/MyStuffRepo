package com.yash.ajax.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.yash.ajax.dao.EmployeeDao;
import com.yash.ajax.domain.Employee;

@WebServlet("/ControllerServlet")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		System.out.println("Servlet Hit");
		PrintWriter out = response.getWriter();
		String value = request.getParameter("id");
		Employee emp = EmployeeDao.fetchUser(value);
		/*out.println((emp.getContact()));
		out.println(emp.getId());
		out.println(emp.getName());*/
		
		Gson gson = new Gson();
		String str = gson.toJson(emp);
		System.out.println(str);
	}

}

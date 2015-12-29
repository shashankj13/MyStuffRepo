package com.yash.dp.stateful;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/TestStateful")
public class TestStateful extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	@EJB
	StatefulSessionBeanLocal ssbl;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		ssbl.setEmpid("123");
		ssbl.setName("shashank");
		ssbl.finish();
	}

}

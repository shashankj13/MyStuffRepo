package com.yash.dp.automatictimer;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TestAutomaticTimer")
public class TestAutomaticTimer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	MyAutoTimer timer;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		timer.startTimer();
	}

}

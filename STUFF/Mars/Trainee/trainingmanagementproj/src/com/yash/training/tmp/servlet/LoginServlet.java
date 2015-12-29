package com.yash.training.tmp.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yash.training.tmp.service.UserLoginService;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @EJB UserLoginService userloginservice;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		userloginservice.authenticateUserService();
	}


}

package com.yash.currencyconvertor.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yash.currencyconvertor.bean.CurrencyConvertorBeanLocal;


@WebServlet("/ConvertorServlet")
public class ConvertorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private CurrencyConvertorBeanLocal ccbl;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		int value_Rs_$ = Integer.parseInt(request.getParameter("amountRS"));
	//	int value_$_Rs = Integer.parseInt(request.getParameter("amountD"));
		System.out.println(" VALUE IN RS " +value_Rs_$);
	//	System.out.println(" VALUE IN $ " +value_$_Rs);
		System.out.println("HELLO THIS IS INSIDE SERVICE NOW GOING TO BEAN");
		System.out.println(ccbl);
		double ouput_$_Rs = ccbl.convert(value_Rs_$);
		out.println("$ VALUE IS " + ouput_$_Rs);
		
		
		
	}

}

package com.yash.helper;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yash.pojo.Customer;

public class HelperClass {

	public static void doProcess(HttpServletRequest request,
			HttpServletResponse response, Customer customer) throws ServletException, IOException {
			System.out.println(customer.getCity());
			System.out.println(customer.getId());
			System.out.println(customer.getName());
			
			request.setAttribute("customer", customer);
			
			request.getRequestDispatcher("/output.jsp").forward(request, response);
	}
}

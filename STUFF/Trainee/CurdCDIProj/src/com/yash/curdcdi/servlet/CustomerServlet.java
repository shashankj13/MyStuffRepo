package com.yash.curdcdi.servlet;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yash.curdcdi.domain.Customer;
import com.yash.curdcdi.service.CustomerService;

@WebServlet("/CustomerServlet") 

public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Inject CustomerService customerService;
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("Submit").equalsIgnoreCase("Select")) {
			try {
				List<Customer> list = customerService.selectCustomer();
				request.getSession().setAttribute("list", list);
				request.getRequestDispatcher("/customerView.jsp").forward(request, response);	
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (request.getParameter("Submit").equalsIgnoreCase("Insert")) {
			int id  = (Integer.parseInt(request.getParameter("id")));
			String name  = request.getParameter("name");
			String city  = request.getParameter("city");
			Customer customer = new Customer();
			customer.setCustomerCity(city);
			customer.setCustomerId(id);
			customer.setCustomerName(name);
			customerService.insertCustomer(customer);
			List<Customer> list;
			try {
				list = customerService.selectCustomer();
				System.out.println(list);
				request.getSession().setAttribute("list", list);
				request.getRequestDispatcher("/customerView.jsp").forward(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		} else if (request.getParameter("Submit").equalsIgnoreCase("Update")) {
			int newId  = (Integer.parseInt(request.getParameter("updateIdNew")));
			int oldId  = (Integer.parseInt(request.getParameter("updateIdOld")));
			customerService.updateCustomer(newId,oldId);
			List<Customer> list;
			try {
				list = customerService.selectCustomer();
				System.out.println(list);
				request.getSession().setAttribute("list", list);
				request.getRequestDispatcher("/customerView.jsp").forward(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} else if (request.getParameter("Submit").equalsIgnoreCase("Delete")) {
			int a  = Integer.parseInt(request.getParameter("deleteId"));
			System.out.println(a);
			customerService.deleteCustomer(a);
			List<Customer> list;
			try {
				list = customerService.selectCustomer();
				System.out.println(list);
				request.getSession().setAttribute("list", list);
				request.getRequestDispatcher("/customerView.jsp").forward(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

	}

}

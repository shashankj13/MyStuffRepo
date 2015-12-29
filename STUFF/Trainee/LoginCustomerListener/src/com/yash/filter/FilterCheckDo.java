package com.yash.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import javax.servlet.http.HttpServletRequest;



public class FilterCheckDo implements Filter {

	public void destroy() {
		
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		 
		
		String url = ((HttpServletRequest) request).getRequestURI().toString();
		System.out.println(url);
		 
		int indexDot = url.lastIndexOf(".");
		if (indexDot == -1) {
			System.out.println("Wrong Url");
		} 
		else {
			String subUrl = url.substring(indexDot);
				if (subUrl.equalsIgnoreCase("do") || indexDot != -1) {
					chain.doFilter(request, response);
				}
				else {
					System.out.println("Your Url is not Allowed");
				}
		}
		System.out.println("DO CHECK FILTER STOPPED");
		  
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}

package com.program.servlet.hello;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/HelloWorldProg")
public class HelloWorldProg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		int fact=1,even=0,odd=0;
		int arrodd[] = new int[50];
		int arreven[] = new int[50];
		
		out.println("HELLO SERVLET" + "<br/>");
		out.println("--------------------" +"<br/>");
		out.println("TABLE OF 5 " + "<br/>");
		for(int i=1;i<=10;i++)
		{
			out.println(i * 5 + "<br/>");
		}
		
		out.println("-------------------------" + "<br/>");
		out.println("Factorial of 5 "  + "<br/>");
		for(int j=1;j<=5;j++){
			fact = fact * j;
		}
		out.println(fact + "<br/>");
		out.println("-------------------------" + "<br/>");
		out.println("Even Odd 1-50" + "<br/>");
		for(int k=1;k<=50;k++)
		{
			if(k%2==0){
				arreven[even]=k;
				even++;
			}
		}
		for(int l=1;l<=50;l++)
		{
			if(l%2!=0){
				arrodd[odd]=l;
				odd++;
			}
		}
			
		out.println("EVEN-----ODD " + "<br/>");
		for(int x=0;x<25;x++){
			out.println(arreven[x] + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + arrodd[x] + "<br/>"); 
			
		}
		
		out.println("-------------------------" + "<br/>");
		out.println("FIBONNACI SERIES" + "<br/>");
		
		int first=0,second=1,third;
		
		out.println(first);
		out.println(second);
		for(int y =1;y<=10;y++){
			third = first + second;
			out.println(third);
			first=second;
			second=third;
			
		}
		
	}

}

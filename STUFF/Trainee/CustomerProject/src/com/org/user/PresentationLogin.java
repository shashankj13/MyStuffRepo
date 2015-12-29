package com.org.user;

import java.util.Scanner;

import com.org.dao.CustomerLoginDao;

public class PresentationLogin {
	private static Scanner input;
	static int id;
	static String password;
	
	public static boolean login(){
		System.out.println("YOUR CREDENTIALS");
		System.out.println("Enter Unique Id");
			input = new Scanner(System.in);
			id = input.nextInt();
		
			System.out.println("Enter Password");
			input = new Scanner(System.in);
			password = input.next();
			
			boolean nameInput = CustomerLoginDao.getCustomerById(id,password);
			System.out.println("HELLO " + id);
			
			return nameInput;
			
			
			
	}

}

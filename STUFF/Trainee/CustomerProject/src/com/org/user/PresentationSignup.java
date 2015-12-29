package com.org.user;


import java.util.Scanner;


import com.org.dao.CustomerSignupDao;
import com.org.domain.Customer;

public class PresentationSignup {
	private static Scanner input;
	static int id;
	static String name;
	static int mobileNumber;
	static String city;
	static String password;

	public static void signup(int id){
		
					System.out.println("Enter Name");
					input = new Scanner(System.in);
					name = input.next();
				
					System.out.println("Enter MobileNumber");
					input = new Scanner(System.in);
					mobileNumber = input.nextInt();
					
					System.out.println("Enter City");
					input = new Scanner(System.in);
					city = input.next();
				
					System.out.println("Enter Password");
					input = new Scanner(System.in);
					password = input.next();
					
					
					
					Customer cust = new Customer();
					cust.setCity(city);
					cust.setMobileNumber(mobileNumber);
					cust.setName(name);
					cust.setPassword(password);
					cust.setId(id);
					
					CustomerSignupDao.insertIntoCustomer(cust);
					
					
					System.out.println("Your Generated Id is : " +id );
					System.out.println("THANKS FOR SIGNING UP");
			
		}

	}


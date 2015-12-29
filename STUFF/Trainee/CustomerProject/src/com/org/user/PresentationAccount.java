package com.org.user;

import java.util.List;
import java.util.Scanner;

import com.org.dao.AccountDao;



public class PresentationAccount {
	
	private static Scanner k;
	public static void checkBalance(){
		System.out.println("ENTER YOUR ACCOUNT NO");
		k = new Scanner(System.in);
		String accno = k.next();
		int amt = AccountDao.checkBalanceDao(accno);
		System.out.println("Current Amount is : " + amt);
	}
	
	public static void deposit(){
		System.out.println("ENTER YOUR ACCOUNT NO");
		k = new Scanner(System.in);
		String accno = k.next();
		System.out.println("ENTER AMOUNT TO BE DEPOSITED");
		k = new Scanner(System.in);
		int amt = k.nextInt();
		AccountDao.depositeDao(accno,amt);
		System.out.println("Successfully Deposited");
		
	}

	public static void withdrawl(){
		System.out.println("ENTER YOUR ACCOUNT NO");
		k = new Scanner(System.in);
		String accno = k.next();
		AccountDao.checkBalanceDao(accno);
		System.out.println("ENTER AMOUNT ");
		k = new Scanner(System.in);
		int amt = k.nextInt();
		System.out.println("Successfully Withdrawn");
		AccountDao.withdrawlDao(accno,amt);
		
	
	}

	public static void showAllAccountHolders(){
		List<?> list = AccountDao.showBenDao();
		for (Object temp : list) {
			System.out.println(temp);
		}
		System.out.println("ENTER YOUR ACCNO ");
		k = new Scanner(System.in);
		String myAccNo=k.next();
		
		System.out.println("NOW ENTER ACCNO NO OF BENIFICIARY");
		k = new Scanner(System.in);
		String benAccNo=k.next();
		
		AccountDao.storeBenDao(myAccNo,benAccNo);
		
		System.out.println("SUCCESS");
		
	
	}
	
	public static void transferAmount(){
		System.out.println("ENTER YOUR ACCNO ");
		k = new Scanner(System.in);
		String myAccNo=k.next();
		
		System.out.println("NOW ENTER ACCNO NO OF BENIFICIARY");
		k = new Scanner(System.in);
		String benAccNo=k.next();
		
		System.out.println("ENTER AMOUNT");
		k = new Scanner(System.in);
		int amt=k.nextInt();
		
/*		AccountDao.checkValidityBenificiary(myAccNo,benAccNo,amt);*/
		AccountDao.withdrawlDao(myAccNo, amt);
		AccountDao.depositeDao(benAccNo, amt);
		
		
	}
}

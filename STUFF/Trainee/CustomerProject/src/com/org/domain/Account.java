package com.org.domain;

import java.util.Scanner;

public class Account {
	
	String accountNo;
	int balance=5000;
	private Scanner k;
	private Scanner k1;
	
	 Account() {
		System.out.println("Enter Account NO");
		k = new Scanner(System.in);
		accountNo = k.next();
		System.out.println("Enter Balance");
		k1 = new Scanner(System.in);
		balance = k1.nextInt();
		
		
	}
	 
	 Account(String s){
		 
	 }
	
	@Override
	
	public String toString() {
		return "accountNo=" + accountNo;
	}
	
	
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}

}

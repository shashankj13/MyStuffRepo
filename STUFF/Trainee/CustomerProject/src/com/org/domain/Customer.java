package com.org.domain;

public class Customer {
	int id;
	String name;
	int mobileNumber;
	String city;
	String password;
	Account account;
	
	public Customer(String a){
		account = new Account(a);
		}
	public Customer(){
	 account = new Account();
	 
	}
	@Override
	public String toString() {
		return "[id=" + id +", account=" + account + "]" + "\n";
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(int mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

}

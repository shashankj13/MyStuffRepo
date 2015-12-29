package com.yash.jsfassignment3.service;

import java.sql.ResultSet;

import com.yash.jsfassignment3.bean.CustomerBean;

public interface CustomerService {
	public void insertCustomer(CustomerBean customerBean);
	public ResultSet authenticateCustomer(String username, String password);
	public void getProduct();
}

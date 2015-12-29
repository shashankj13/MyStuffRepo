package com.yash.curdcdi.service;

import java.util.List;

import com.yash.curdcdi.domain.Customer;

public interface CustomerService {
	public void insertCustomer(Customer customer);
	public void deleteCustomer(int id);
	public void updateCustomer(int idNew,int idOld);
	public List<Customer> selectCustomer() throws Exception;
}

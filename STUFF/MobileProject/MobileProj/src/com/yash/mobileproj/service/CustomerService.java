package com.yash.mobileproj.service;

import java.util.List;

import com.yash.mobileproj.domain.Customer;
import com.yash.mobileproj.domain.MobileDetails;

public interface CustomerService {
	public void insertCustomer(Customer customer);
	public Customer authenticateCustomer(String username, String password);
	public void getProduct(int i) throws Exception;
	public List<MobileDetails> getAllMobileDetails(String string) throws Exception;
}

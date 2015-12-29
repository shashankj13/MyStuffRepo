package com.yash.mobileproj.service;

import java.sql.SQLException;
import java.util.List;

import com.yash.mobileproj.domain.Admin;
import com.yash.mobileproj.domain.Customer;

public interface AdminService {
	
	public void deleteCustomer();
	public void addProduct();
	public void deleteProduct();
	public void updateProduct();
	public Admin authenticateAdmin(String username, String password);
	public List<Customer> fetchAllCustomers() throws SQLException;
	
}

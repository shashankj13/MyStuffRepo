package com.yash.mobileproj.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import com.yash.mobileproj.dao.AdminDao;
import com.yash.mobileproj.domain.Admin;
import com.yash.mobileproj.domain.Customer;

public class AdminServiceImpl implements AdminService{

	@Inject AdminDao adminDao;
	Admin admin = new Admin();
	
	@Override
	public void deleteCustomer() {
		
		
	}

	@Override
	public void addProduct() {
		
		
	}

	@Override
	public void deleteProduct() {
		
		
	}

	@Override
	public void updateProduct() {
	
		
	}

	@Override
	public Admin authenticateAdmin(String username, String password) {
		ResultSet resultSet;
		String name2 = null;
		String sql = "SELECT * FROM ADMIN WHERE USERNAME = '"+username+"' AND PASSWORD = '"+password+"'";
		System.out.println("Query of select : " +sql);
		System.out.println("Object of Dao in Service " + adminDao);
		 resultSet = adminDao.select(sql);
		try {
			if(resultSet.next()){
				 System.out.println("INSIDE SERVICE");
				 String username1=resultSet.getString(2);
				 
				 System.out.println(username +  username1);
				 
				 if(username1.equals(username)){
					 System.out.println("INSIDE SERVICE AND IF ");
					 admin.setName(resultSet.getString("name"));
					 admin.setUsername(resultSet.getString("username"));
					 admin.setPassword(resultSet.getString("password"));
					 name2 = resultSet.getString(1);
					 System.out.println(name2);
					 return admin;
				 }
			}
			else{
				return null;
			}
				
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return admin;
	}

	@Override
	public List<Customer> fetchAllCustomers() throws SQLException {
		List<Customer> list = new ArrayList<>();
		String sql="SELECT USERNAME,NAME,CONTACT,EMAIL,CITY FROM CUSTOMER ";
		ResultSet rs =  adminDao.select(sql);
		while(rs.next()){
			Customer customer = new Customer();
			customer.setCity(rs.getString("city"));
			customer.setName(rs.getString("name"));
			customer.setContact(rs.getString("contact"));
			customer.setEmail(rs.getString("email"));
			customer.setUsername(rs.getString("username"));
			list.add(customer);
		}
		
		return list;
	}
	
	
}

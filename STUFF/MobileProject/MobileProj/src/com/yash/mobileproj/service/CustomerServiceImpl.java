package com.yash.mobileproj.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import com.yash.mobileproj.dao.CustomerDao;
import com.yash.mobileproj.domain.Customer;
import com.yash.mobileproj.domain.MobileDetails;

public class CustomerServiceImpl implements CustomerService {
	
	@Inject 
	CustomerDao customerDao;
	Customer customer = new Customer();

	
	
	@Override
	public Customer authenticateCustomer(String username, String password) {
		ResultSet resultSet;
		String name2=null;
		String sql = "SELECT * FROM CUSTOMER WHERE USERNAME = '"+username+"' AND PASSWORD = '"+password+"'";
		System.out.println("Query of select : " +sql);
		System.out.println("Object of Dao in Service " + customerDao);
		resultSet = customerDao.select(sql);
		try {
			if(resultSet.next()){
				 System.out.println("INSIDE SERVICE");
				 String username1=resultSet.getString(1);
				 System.out.println(username +  username1);
				 
				 if(username1.equals(username)){
					 System.out.println("INSIDE SERVICE AND IF ");
					 customer.setName(resultSet.getString("name"));
					 customer.setUsername(resultSet.getString("username"));
					 customer.setPassword(resultSet.getString("password"));
					 customer.setContact(resultSet.getString("contact"));
					 customer.setCity(resultSet.getString("city"));
					 customer.setEmail(resultSet.getString("email"));
					 name2 = resultSet.getString(3);
					 System.out.println(name2);
					 return customer;
				 }
			}else{
				return null;
			}
				
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return customer;

	}

	@Override
	public void getProduct(int id) throws Exception{
		ResultSet resultSet;
		String sql = "SELECT * FROM MOBILEDETAIL WHERE ID = " + id;
		resultSet = customerDao.select(sql);
		while (resultSet.next()) {
			
			
		}
	}



	@Override
	public void insertCustomer(Customer customer) {
		String sql = "INSERT INTO CUSTOMER VALUES ('"+ customer.getUsername() +"' , '"+ customer.getPassword() +"' ,'"+ customer.getName() +"' ,'"+ customer.getContact() +"' ,'"+ customer.getEmail() +"' ,'"+ customer.getCity() +"')";
		System.out.println(sql);
		customerDao.update(sql);
		
	}

	@Override
	public List<MobileDetails> getAllMobileDetails(String string) throws Exception {
		List<MobileDetails> list = new ArrayList<>();
		String sql = "SELECT * FROM MOBILEDETAILS WHERE PHONENAME = '" + string+"'" ;
		System.out.println(sql);
		ResultSet rs = customerDao.select(sql);
		while(rs.next()){
			MobileDetails md = new MobileDetails();
			md.setId(rs.getInt("id"));
			md.setColor(rs.getString("color"));
			md.setDescription(rs.getString("description"));
			md.setPhonename(rs.getString("color"));
			md.setPrice(rs.getInt("price"));
			list.add(md);
			
		}
		return list;
	}

}

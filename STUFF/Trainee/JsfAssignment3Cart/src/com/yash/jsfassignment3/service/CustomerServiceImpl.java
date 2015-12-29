 package com.yash.jsfassignment3.service;

import java.sql.ResultSet;

import com.yash.jsfassignment3.bean.CustomerBean;
import com.yash.jsfassignment3.dao.CustomerDao;
import com.yash.jsfassignment3.dao.CustomerDaoImpl;

public class CustomerServiceImpl implements CustomerService {
	

	CustomerDao customerDao = new CustomerDaoImpl();
	ResultSet resultSet=null;

	public void insertCustomer(CustomerBean customerBean) {

		String sql = "INSERT INTO CUSTOMER(NAME,CONTACT,EMAIL,ADDRESS,USERNAME,PASSWORD) VALUES ('"
				+ customerBean.getName()
				+ "' ,  "
				+ customerBean.getContact()
				+ "  ,  '"
				+ customerBean.getEmail()
				+ "'  ,  '"
				+ customerBean.getAddress()
				+ "'  ,   '"
				+ customerBean.getUserName()
				+ "' ,  '"
				+ customerBean.getPassword() + "')";

		customerDao.update(sql);

	}

	@Override
	public ResultSet authenticateCustomer(String username, String password) {
		
		String sql = "SELECT * FROM CUSTOMER WHERE USERNAME='"
				+ username + "' AND PASSWORD='" + password + "'";
		resultSet = customerDao.select(sql);
		
		
		return resultSet;

	}

	@Override
	public void getProduct() {
		// TODO Auto-generated method stub
		
	}

}

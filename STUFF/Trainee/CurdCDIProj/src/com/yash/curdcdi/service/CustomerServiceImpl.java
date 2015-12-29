package com.yash.curdcdi.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import com.yash.curdcdi.dao.CustomerDao;
import com.yash.curdcdi.domain.Customer;




public class CustomerServiceImpl implements CustomerService{

	@Inject CustomerDao customerDao;
	
	@Override
	public void insertCustomer(Customer customer) {
		String sql = "INSERT INTO CUSTOMER(CUSTOMERID,CUSTOMERNAME,CUSTOMERCITY) VALUES ("+customer.getCustomerId()+",'"+customer.getCustomerName()+"','"+customer.getCustomerCity()+"')";
		customerDao.update(sql);
	}

	@Override
	public void deleteCustomer(int id) {
		String sql = "DELETE FROM CUSTOMER WHERE CUSTOMERID = " +id;
		customerDao.update(sql);
		
	}

	@Override
	public void updateCustomer(int idNew , int idOld) {
		String sql = "UPDATE CUSTOMER SET CUSTOMERID = "+ idNew +" where CUSTOMERID =" +idOld;
		customerDao.update(sql);
	}

	@Override
	public List<Customer> selectCustomer() throws SQLException {
		List<Customer> list = new ArrayList<>();
		String sql = "SELECT * FROM CUSTOMER ";
		ResultSet rs = customerDao.select(sql);
		while(rs.next()){
			Customer customer = new Customer();
			customer.setCustomerId(rs.getInt(1));
			customer.setCustomerName(rs.getString(2));
			customer.setCustomerCity(rs.getString(3));
			list.add(customer);
		}
		return list;
	}
	

}

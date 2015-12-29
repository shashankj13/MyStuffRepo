package com.yash.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.yash.domain.Customer;
import com.yash.util.ConnectionProvider;

public class CustomerDao {
	public static List<Customer> showCustomer(int id) {

		Connection conn = ConnectionProvider.getConnection();
		List<Customer> list = new ArrayList<>();

		try {
			System.out.println(id);
			String query = "SELECT ID,NAME,CITY,MOBILE FROM CUSTOMER WHERE ID = ?";
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Customer customer = new Customer();
				System.out.println(rs.getString("NAME"));
				customer.setId(rs.getInt("ID"));
				customer.setName(rs.getString("NAME"));
				customer.setMobile(rs.getInt("MOBILE"));
				customer.setCity(rs.getString("CITY"));

				list.add(customer);
			}

		} catch (Exception e) {
			e.getMessage();
		}

		return list;
	}

	public static List<Customer> showAllCustomer() {

		Connection conn = ConnectionProvider.getConnection();
		List<Customer> list = new ArrayList<>();

		try {

			String query = "SELECT * FROM CUSTOMER";
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Customer customer = new Customer();
				System.out.println(rs.getString("NAME"));
				customer.setId(rs.getInt("ID"));
				customer.setName(rs.getString("NAME"));
				customer.setMobile(rs.getInt("MOBILE"));
				customer.setCity(rs.getString("CITY"));
				list.add(customer);
			}

		} catch (Exception e) {
			e.getMessage();
		}

		return list;
	}

}

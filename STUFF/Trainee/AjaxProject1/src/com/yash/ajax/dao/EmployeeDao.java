package com.yash.ajax.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.yash.ajax.domain.Employee;
import com.yash.ajax.util.ConnectionProvider;

public class EmployeeDao {
	static Employee emp;

	public static Employee fetchUser(String value) {

		try {

			Connection connection = ConnectionProvider.getConnection();
			String sql = "SELECT * FROM EMPLOYEE WHERE id=?";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, value);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				emp = new Employee();
				emp.setId(rs.getString("id"));
				emp.setContact(rs.getInt("contact"));
				emp.setName(rs.getString("name"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return emp;
	}

}

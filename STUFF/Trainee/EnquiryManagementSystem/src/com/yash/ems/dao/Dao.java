package com.yash.ems.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import com.yash.ems.domain.Enquiry;
import com.yash.ems.domain.User;

public class Dao {

	public static void insertuser(User user) {
		try {
			Connection connection = ConnectionProvider.getConnection();

			String sql = "INSERT INTO USER (NAME,EMAIL,TYPE,STATUS,USERNAME,PASSWORD) VALUES (?,?,?,?,?,?)";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getEmail());
			pstmt.setInt(3, user.getType());
			pstmt.setInt(4, user.getStatus());
			pstmt.setString(5, user.getUsername());
			pstmt.setString(6, user.getPassword());
			pstmt.executeUpdate();
			System.out.println("SUCCESS");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static int id = 0;

	public static int fetchUser(User user) {

		try {

			Connection connection = ConnectionProvider.getConnection();
			String sql = "SELECT USERID FROM USER WHERE USERNAME=? AND PASSWORD=?";
			PreparedStatement pstmt = connection.prepareStatement(sql);

			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				id = rs.getInt(1);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return id;
	}

	public static List<Enquiry> displayEnquiry(int id) {
		List<Enquiry> list = new ArrayList<>();
		try {

			Connection connection = ConnectionProvider.getConnection();
			String sql = "SELECT * FROM ENQUIRY WHERE USERID=" + id;
			PreparedStatement pstmt = connection.prepareStatement(sql);

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Enquiry enquiry = new Enquiry();
				enquiry.setEnqid(rs.getInt("enqid"));
				enquiry.setName(rs.getString("name"));
				enquiry.setUserid(rs.getInt("userid"));
				enquiry.setContact(rs.getInt("contact"));
				enquiry.setEmail(rs.getString("email"));
				list.add(enquiry);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;

	}

	public static int insertEnquiry(Enquiry enquiry) {
		try {
			Connection connection = ConnectionProvider.getConnection();

			String sql = "INSERT INTO ENQUIRY (NAME,EMAIL,CONTACT,USERID) VALUES (?,?,?,?)";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, enquiry.getName());
			pstmt.setString(2, enquiry.getEmail());
			pstmt.setInt(3, enquiry.getContact());
			pstmt.setInt(4, id);
			pstmt.executeUpdate();
			System.out.println("SUCCESS");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return id;

	}

}

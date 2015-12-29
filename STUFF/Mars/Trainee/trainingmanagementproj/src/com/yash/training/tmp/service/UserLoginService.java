package com.yash.training.tmp.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.ejb.LocalBean;
import javax.ejb.Stateful;

import com.yash.training.tmp.domain.User;
import com.yash.training.tmp.util.Util;


/**
 * Session Bean implementation class UserLoginService
 */

@Stateful
@LocalBean
public class UserLoginService implements UserLoginServiceLocal {
	
	@Override
	public User authenticateUserService() {
		
    	String query1= "SELECT * FROM USER";
    	ResultSet rs = Util.select(query1);
    	User user = null;
    	try {
			while(rs.next()){
				user = new User();
				user.setUser_id(rs.getInt("user_id"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setContact(rs.getString("contact"));
				user.setUsername(rs.getString("username"));
				System.out.println(rs.getInt("user_id") +  rs.getString("name"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return user;
    }     
}

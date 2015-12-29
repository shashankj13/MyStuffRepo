package com.yash.training.tmp.service;

import java.sql.ResultSet;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import com.yash.training.tmp.bean.UserBean;
import com.yash.training.tmp.domain.User;
import com.yash.training.tmp.util.DButil;

/**
 * Session Bean implementation class UserService
 */

/**
 * 
 * @author shashank.juneja
 *
 */

@Stateless
@LocalBean
public class UserService implements UserServiceLocal {

	@Inject 
	User user;
	
	/**
	 * userAuthenticate method
	 */
	public String userAuthenticate(String userName, String password) throws Exception {

		String query = "SELECT * FROM USER WHERE USERNAME='"+userName+"'AND PASSWORD='"+password+"'";
		ResultSet resultSet = DButil.select(query);
		if(resultSet.next()){
			
			
			/*String userName1 = resultSet.getString("USERNAME");
			String password1 = resultSet.getString("PASSWORD");*/
			String name = resultSet.getString("NAME");
			user.setName(name);
			user.setUsername(userName);
			user.setPassword(password);		
			
			System.out.println("IN USER SERVICE ---------------------" + resultSet.getInt("USER_ID") );
            
			return "success";
		}else{
			
			String checkusername = "SELECT USERNAME FROM USER WHERE USERNAME='"+userName+"'";
			String checkpassword = "SELECT PASSWORD FROM USER WHERE PASSWORD='"+password+"'";
			ResultSet userSet = DButil.select(checkusername);
			ResultSet passwordSet = DButil.select(checkpassword);
			if (userSet.next()) {
				return "Invalid Password";
			}
			if (passwordSet.next()) {
				return "Invalid Username";
			} else {
				return "Invalid UserName and Password";
			}
				
		}
	}
	
	
	@Override
	public void userRegistration(UserBean userBean) throws Exception {

		String query = "INSERT INTO USER(NAME,CONTACT,EMAILID,DESIGNATION, USERNAME, PASSWORD,STATUS, ROLE) "
				+ "VALUES ('"+userBean.getName()+"','"+userBean.getContact()+"','"+userBean.getEmail()+"','"+userBean.getDesignation()+"',"
						+ "'"+userBean.getUserName()+"','"+userBean.getPassword()+"',1,2)";
		
		DButil.update(query);
		
	}


	@Override
	public User getUserName(String userName, String password) throws Exception {
		String query = "SELECT * FROM USER WHERE USERNAME = '"+userName+"' AND PASSWORD ='"+password+"'";
		ResultSet resultSet = DButil.select(query);
		while(resultSet.next()){
			String name = resultSet.getString("NAME");
			user.setName(name);
			
			int user_ID = resultSet.getInt("USER_ID") ;
			user.setUserid(user_ID);
			
			int d_id = resultSet.getInt("designation");
			user.setDesignation_id(d_id);
			System.out.println("------------------D_ID-----------------------" +d_id);
		}
		
		return user;
	}
 
}

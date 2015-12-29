package com.yash.training.tmp.service;

import javax.ejb.Local;

import com.yash.training.tmp.bean.UserBean;
import com.yash.training.tmp.domain.User;

@Local
public interface UserServiceLocal {
	
	public String userAuthenticate(String userName, String password) throws Exception;
	public void userRegistration(UserBean userBean) throws Exception;
	public User getUserName(String userName, String password) throws Exception;

}

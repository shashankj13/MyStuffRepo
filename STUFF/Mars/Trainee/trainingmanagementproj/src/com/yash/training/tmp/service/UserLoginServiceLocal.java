package com.yash.training.tmp.service;

import javax.ejb.Local;

import com.yash.training.tmp.domain.User;

@Local
public interface UserLoginServiceLocal {

	User authenticateUserService();

	
}

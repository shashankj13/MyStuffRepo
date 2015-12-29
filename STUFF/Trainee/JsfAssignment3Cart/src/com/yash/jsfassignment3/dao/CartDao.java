package com.yash.jsfassignment3.dao;

import java.sql.ResultSet;

public interface CartDao {

	public ResultSet select(String query);
	public void update(String query);
}

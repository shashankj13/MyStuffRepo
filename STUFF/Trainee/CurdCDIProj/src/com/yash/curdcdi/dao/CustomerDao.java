package com.yash.curdcdi.dao;

import java.sql.ResultSet;

public interface CustomerDao {
	
	public ResultSet select(String query);
	public void update(String query);

}

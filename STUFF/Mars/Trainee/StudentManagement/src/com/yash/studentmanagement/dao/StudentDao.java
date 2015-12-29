package com.yash.studentmanagement.dao;

import java.sql.ResultSet;

public interface StudentDao {
	
	public ResultSet select(String query);
	public void update(String query);

}

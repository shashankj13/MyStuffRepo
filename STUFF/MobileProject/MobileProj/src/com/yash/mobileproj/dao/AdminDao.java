package com.yash.mobileproj.dao;

import java.sql.ResultSet;

public interface AdminDao {

	public ResultSet select(String query);
	public void update(String query);

}

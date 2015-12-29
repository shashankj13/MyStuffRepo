package com.yash.training.tmp.test;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.yash.training.tmp.util.Util;

public class TestUtil {

	public void checkUtil() throws SQLException {

		String sql1 = "SELECT * FROM USER";
		System.out.println(sql1);
		ResultSet resultSet = Util.select(sql1);
		while (resultSet.next()) {
			System.out.println(resultSet.getInt("user_id"));
		}
		/*
		 * String sql2 = "SELECT * FROM USER"; String sql3 =
		 * "SELECT * FROM USER"; String sql4 = "SELECT * FROM USER"; String sql5
		 * = "SELECT * FROM USER"; String sql6 = "SELECT * FROM USER"; String
		 * sql7 = "SELECT * FROM USER"; String sql8 = "SELECT * FROM USER";
		 * String sql9 = "SELECT * FROM USER"; String sql10 =
		 * "SELECT * FROM USER";
		 */

	}

}

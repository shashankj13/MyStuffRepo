package com.yash.demo;

import java.sql.SQLException;

class A{
public void A1() throws SQLException{
		throw new SQLException();
	}
	
}

class B extends A{
	
	public void B1() throws SQLException{
		A1();
	}
}

class ThreadDemo{
	public static void main(String ars[]) throws SQLException{
		B b1 = new B();
		b1.B1();
	
	}
}

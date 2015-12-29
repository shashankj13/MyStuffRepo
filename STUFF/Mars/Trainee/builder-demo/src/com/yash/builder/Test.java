package com.yash.builder;

public class Test {

	public static void main(String[] args) {
		Mobile mobile = new MobileBuilder(20000,"MOTO",5).build();
		System.out.println(mobile);
	}

	
}

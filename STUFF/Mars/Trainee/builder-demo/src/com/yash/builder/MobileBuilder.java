package com.yash.builder;

public class MobileBuilder {
	
	Mobile mobile = new Mobile();
	
	public Mobile getMobile() {
		return mobile;
	}

	public void setMobile(Mobile mobile) {
		this.mobile = mobile;
	}

	public MobileBuilder(int amount,String brand,int size ) {
		mobile.getPrice().setAmount(amount);
		mobile.getBrand().setType(brand);
		mobile.getSize().setInch(size);
	}
	
	public Mobile build(){
		return this.mobile;
	}
	
}

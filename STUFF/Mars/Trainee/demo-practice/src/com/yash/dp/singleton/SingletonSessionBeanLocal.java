package com.yash.dp.singleton;

import javax.ejb.Local;

@Local
public interface SingletonSessionBeanLocal {
	public void increment();
	public int getNumber();

}

package com.yash.dp.singleton;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;


@Singleton
@LocalBean
public class SingletonSessionBean implements SingletonSessionBeanLocal {

   
	private int number;
	
    public SingletonSessionBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void increment() {
		number++;
		
	}

	@Override
	public int getNumber() {
		return number;
	}

}

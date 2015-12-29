package com.yash.dp.stateful;

import javax.ejb.Local;

@Local
public interface StatefulSessionBeanLocal {
	
	public void setEmpid(String string);
	public void setName(String string);
	public void finish();
	public void sessionClosed();
}

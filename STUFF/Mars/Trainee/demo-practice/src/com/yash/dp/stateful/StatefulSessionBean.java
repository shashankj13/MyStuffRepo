package com.yash.dp.stateful;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;

@Stateful
@LocalBean
public class StatefulSessionBean implements StatefulSessionBeanLocal {

	private String name;
	private String empid;
  
    public StatefulSessionBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void finish() {
		Employee employee = new Employee();
		employee.setEmpid(empid);
		employee.setName(name);
		
		
	}

	@Override
	public void sessionClosed() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setEmpid(String string) {
		
		
	}

	@Override
	public void setName(String string) {
		// TODO Auto-generated method stub
		
	}

}

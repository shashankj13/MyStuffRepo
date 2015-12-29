package ComponentsJSFDemo.src.com.yash.training.service;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import ComponentsJSFDemo.src.com.yash.jsftraining.bean.EmployeeDB;
import ComponentsJSFDemo.src.com.yash.jsftraining.db.DBUtil;

@Stateless

public class EmployeeServiceImpl implements EmployeeServiceIntf{
	private String sql;
	private List<EmployeeDB> employeeList;
	
	public EmployeeServiceImpl()  {
		try {
			DBUtil.connectDB();
			employeeList=new ArrayList<EmployeeDB>();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public List<EmployeeDB> getAllEmployees() throws Exception{
		sql="select * from employee";
		ResultSet rs=DBUtil.select(sql);
		employeeList=new ArrayList<EmployeeDB>();
		EmployeeDB employee;
		while(rs.next()){
			employee=new EmployeeDB();
			employee.setId(rs.getInt(1));
			employee.setName(rs.getString(2));
			employee.setSalary(rs.getInt(3));
			employeeList.add(employee);		
		}
		return employeeList;
	}
	@Override
	public void deleteEmployee(int empid) throws Exception {
		sql="delete from employee where id='"+empid+"'";
		DBUtil.update(sql);
		
		System.out.println("-------deleted -  check DB--------");
	}
	

}

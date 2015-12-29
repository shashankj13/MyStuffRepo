package com.yash.crudapplication.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yash.crudapplication.domain.Employee;
import com.yash.crudapplication.util.DButil;

public class EmployeeDao {

	public void saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		String sql = "insert into employeedetails(employeename, employeecontact, employeeaddress)"
				+ " values ('"+employee.getEmployeeName()+"','"+employee.getEmployeeContact()+"','"+employee.getEmployeeAddress()+"')";
		try {
			DButil.update(sql);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public List<Employee> getAllDetails() {
		String sql = "select * from employeedetails";
		List<Employee> employees = new ArrayList<>();
		ResultSet resultSet = DButil.select(sql);
		try {
			while(resultSet.next()){
				Employee employee = new Employee();
				employee.setEmployeeId(resultSet.getInt("employeeid"));
				employee.setEmployeeName(resultSet.getString("employeename"));
				employee.setEmployeeContact(resultSet.getString("employeecontact"));
				employee.setEmployeeAddress(resultSet.getString("employeeaddress"));
				employees.add(employee);
				
			}
			return employees;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void deleteEmployee(int employeeId) {
		
	
			String sql = "delete from employeedetails where employeeid = '"+employeeId+"'";
			try {
				DButil.update(sql);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		
		
		
		
	}

	public Employee getEmployeeDetails(int employeeId) {
		String sql = "Select * from employeedetails where employeeid ="+employeeId;
		ResultSet resultSet = DButil.select(sql);
		Employee employee = new Employee(); 
		try {
			while(resultSet.next()){
				employee.setEmployeeId(employeeId);
				employee.setEmployeeName(resultSet.getString("employeename"));
				employee.setEmployeeContact(resultSet.getString("employeecontact"));
				employee.setEmployeeAddress(resultSet.getString("employeeAddress"));	
			}
			return employee;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

	public void updateEmployeeDetails(Employee employee) {
		String sql = "update employeedetails set employeename = '"+employee.getEmployeeName()+"', employeecontact = '"+employee.getEmployeeContact()+"', employeeaddress = '"+employee.getEmployeeAddress()+"'"
				+ "where employeeid = '"+employee.getEmployeeId()+"'";
		try {
			DButil.update(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	

}

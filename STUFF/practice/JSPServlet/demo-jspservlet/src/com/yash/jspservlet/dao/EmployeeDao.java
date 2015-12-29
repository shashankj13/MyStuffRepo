package com.yash.jspservlet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.yash.jspservlet.domain.Employee;
import com.yash.jspservlet.util.DButil;

public class EmployeeDao {
	
	public List<Employee> getAllEmployee(){
	List<Employee> list = new ArrayList<>();
   	 Connection connection;
	try {
		connection = DButil.connectDB();
		String sql = "SELECT * FROM EMPLOYEE";
		ResultSet resultSet = connection.prepareStatement(sql).executeQuery(); 
		while(resultSet.next()){
			Employee employee = new Employee();
			employee.setEmployeeId(resultSet.getInt(1));
			employee.setName(resultSet.getString(2));
			employee.setCity(resultSet.getString(3));
			list.add(employee);
		}
	} catch (Exception e) {
		e.printStackTrace();
		System.out.println("----------------SELECT QUERY FAILED--------------------");
	}
       
       
       return list;
   }
  
   
   public void deleteEmployee(Employee employee){
       try{
    	   Connection connection =  DButil.connectDB();
    	   String sql = "DELETE FROM EMPLOYEE WHERE EMPLOYEE_ID="+employee.getEmployeeId();
           connection.prepareStatement(sql).executeUpdate();
       }
       catch(Exception ex){
           ex.printStackTrace();
           System.out.println("----------------DELETE QUERY FAILED--------------------");
       }
   }
   
   public void addEmployee(Employee employee){
	   try{
    	   Connection connection =  DButil.connectDB();
    	   String sql = "INSERT INTO EMPLOYEE (NAME,CITY) VALUES ('"+employee.getName()+"','"+employee.getCity()+"')";
           connection.prepareStatement(sql).executeUpdate();
       }
       catch(Exception ex){
           ex.printStackTrace();
           System.out.println("----------------DELETE QUERY FAILED--------------------");
       }
   }


public void updateEmployeeDetails(Employee employee) {
	try{
 	   Connection connection =  DButil.connectDB();
 	   String sql = "UPDATE EMPLOYEE SET NAME = ? , CITY = ? WHERE EMPLOYEE_ID = ? ";
 	   PreparedStatement pst = connection.prepareStatement(sql);
 	   pst.setString(1, employee.getName());
 	   pst.setString(2, employee.getCity());
 	   pst.setInt(3, employee.getEmployeeId());
 	   pst.executeUpdate();
      
    }
    catch(Exception ex){
        ex.printStackTrace();
        System.out.println("----------------UPDATE QUERY FAILED--------------------");
    }
	
}

}

package com.yash.jspsample2.bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean
@SessionScoped
public class EmployeeBean {
		
		private String name;
		private String salary;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getSalary() {
			return salary;
		}
		public void setSalary(String salary) {
			this.salary = salary;
		}
		public String saveEmployee(){
		     
		    try{  
		    	Class.forName("com.mysql.jdbc.Driver");    
		    	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jsfdb","root","root"); 
		    	PreparedStatement ps=con.prepareStatement("INSERT INTO EMPTABLE VALUES (?,?)");
		    	ps.setString(1, name);
		    	ps.setString(2, salary);
		    	ps.executeUpdate();
		    	
		    }
		    
		    catch(Exception e){ 
		    	System.out.println(e);
		    }  
		       
			return "success";
		}
}


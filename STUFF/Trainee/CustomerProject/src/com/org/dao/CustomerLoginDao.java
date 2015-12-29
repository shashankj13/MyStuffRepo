package com.org.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;






import com.org.util.ConnectionProvider;

public class CustomerLoginDao {

	
		
		public static boolean getCustomerById(int idInput,String passwordInput){
			boolean flag=false;
			Connection connection = ConnectionProvider.getConnection();
			String query = "SELECT * FROM CUSTOMER WHERE ID=" + idInput;
			
			
			try {
				Statement stmt=connection.createStatement();    
				ResultSet resultset=stmt.executeQuery(query);  
				while(resultset.next()){  
					int id = resultset.getInt(1);
					 String password = resultset.getString(5);
					if(id==idInput){
						if(password.equals(passwordInput)){
							
							flag=true;
						}
						 
						}
				
				}
				
			} catch (Exception e) {                  
				System.out.println("ERROR");
				
			}
			return flag;
			
	
			
			
		}
		
		
	

}

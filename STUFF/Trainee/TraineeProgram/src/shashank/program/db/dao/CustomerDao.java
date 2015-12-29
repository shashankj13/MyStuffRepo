package shashank.program.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import shashank.program.db.domain.Customer;
import shashank.program.db.util.ConnectionProvider;

public class CustomerDao {
	
	public static int  setMaxId(){
		Connection connection = ConnectionProvider.getConnection();
		String query = "SELECT MAX(ID) FROM CUSTOMER";
		Statement statement;
		int id=0;
		try {
			statement = connection.createStatement();
			ResultSet resultset = statement.executeQuery(query);
			while(resultset.next()){
				id = resultset.getInt(1);
			}
			return id;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		
		
		
		
	}
	
	public static  void insertIntoCustomer(Customer customer){
		Connection connection = ConnectionProvider.getConnection();
		String query = "INSERT INTO CUSTOMER VALUES(?,?,?)";
		
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1,customer.getId());
			preparedStatement.setString(2,customer.getName());
			preparedStatement.setString(3,customer.getAddress());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}
	public static List<Customer> getAllCustomer(Customer customer){
		
		List <Customer> list = new ArrayList<Customer>();
		Connection connection = ConnectionProvider.getConnection();
		String query = "SELECT * FROM CUSTOMER";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.executeQuery();
			ResultSet resultset = preparedStatement.executeQuery(query);
			while(resultset.next()){
				int id = resultset.getInt(1);		
				String name = resultset.getString(2);		
				String address = resultset.getString(3);
				list.add(new Customer(id,name,address));
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return list;
		
	}
	
	public static void deleteCustomer( int idInput){
		
		Connection connection = ConnectionProvider.getConnection();
		
		try {
			PreparedStatement stmt=connection.prepareStatement("DELETE FROM CUSTOMER WHERE ID = ?");  
			stmt.setInt(1,idInput);
			stmt.executeUpdate();  
			
			
		} catch (Exception e) {
			System.out.println("ERROR");
		}
		
		
	}
	public static Customer getCustomerById(int idInput){
		Connection connection = ConnectionProvider.getConnection();
		Customer customer=null;
		String query = "SELECT * FROM CUSTOMER WHERE ID=" + idInput;
		try {
			Statement stmt=connection.createStatement();    
			ResultSet resultset=stmt.executeQuery(query);  
			while(resultset.next()){  
				int id = resultset.getInt(1);		
				String name = resultset.getString(2);		
				String address = resultset.getString(3);
				customer =new Customer(id,name,address);
			} 
			
			
		} catch (Exception e) {
			System.out.println("ERROR");
		}
		return customer;
		
		
	}
	
	public static void updateCustomer(int idInput,String nameInput,int option){
		Connection connection = ConnectionProvider.getConnection();
		
		try {
			if(option==1){
			PreparedStatement stmt=connection.prepareStatement("UPDATE CUSTOMER SET NAME = ? WHERE ID = ?");  
			stmt.setString(1,nameInput);
			stmt.setInt(2,idInput);
			stmt.executeUpdate();}
			
			if(option==0){
				PreparedStatement stmt=connection.prepareStatement("UPDATE CUSTOMER SET ADDRESS = ? WHERE ID = ?");  
				stmt.setString(1,nameInput);
				stmt.setInt(2,idInput);
				stmt.executeUpdate();}
			
			
		} catch (Exception e) {
			System.out.println("ERROR UPDATE");
		}
	}

}

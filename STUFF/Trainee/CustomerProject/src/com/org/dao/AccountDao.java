package com.org.dao;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import com.org.domain.Account;
import com.org.domain.Customer;
import com.org.util.ConnectionProvider;

public class AccountDao {
	
	
	public static int checkBalanceDao(String accno){
		Connection connection = ConnectionProvider.getConnection();
		String query = "SELECT BALANCE FROM ACCOUNT WHERE accno=?";
		
	
	
		int amount=0;
		try {
			PreparedStatement preparedstatement = connection.prepareStatement(query);
			preparedstatement.setString(1,accno);
			
			ResultSet resultset = preparedstatement.executeQuery();
	
			
			while(resultset.next()){
				
				amount = resultset.getInt(1);
				
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		return amount;
		
	}
	
	public static void depositeDao(String accno,int amt){
Connection connection = ConnectionProvider.getConnection();
		
		try {
			
			PreparedStatement stmt=connection.prepareStatement("UPDATE ACCOUNT SET BALANCE = "
					+ "(BALANCE+ ?) WHERE ACCNO = ?");  
			stmt.setInt(1,amt);
			stmt.setString(2,accno);
			stmt.executeUpdate();
		
			
		} catch (Exception e) {
			System.out.println("ERROR UPDATE");
		}
	}
		
	
	
	public static void withdrawlDao(String accno, int amt){
		
		
			Connection connection = ConnectionProvider.getConnection();
			String query = "SELECT BALANCE FROM ACCOUNT WHERE accno=?";
			
		
		
			int amount=0;
			try {
				PreparedStatement preparedstatement = connection.prepareStatement(query);
				preparedstatement.setString(1,accno);
				
				ResultSet resultset = preparedstatement.executeQuery();
		
				
				while(resultset.next()){
					
					amount = resultset.getInt(1);
					
				}
				
				if(amount < amt){
					System.out.println("EXCEPTION : TRANSACTION NOT POSSIBLE");
				}
				else{
					
					try {
						PreparedStatement stmt=connection.prepareStatement("UPDATE ACCOUNT SET BALANCE = (BALANCE- ?) WHERE ACCNO = ?");  
						stmt.setInt(1,amt);
						stmt.setString(2,accno);
						stmt.executeUpdate();
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
			
		}
		catch(Exception e ){}
	

	}

	public static List<Customer> showBenDao() {
		
		List <Customer> list = new ArrayList<>();
		Connection connection = ConnectionProvider.getConnection();
		String query = "SELECT * FROM customer c INNER JOIN account a ON c.id = a.id;";
		String random="NO USE";
		
		try {
			PreparedStatement preparedstatement = connection.prepareStatement(query);
			ResultSet resultset = preparedstatement.executeQuery();
	
			
			while(resultset.next()){
				Customer cust = new Customer(random);
				Account account=cust.getAccount();
				cust.setId(resultset.getInt(1));
				account.setAccountNo(resultset.getString(7));
				cust.setAccount(account);
				list.add(cust);
				
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		return list;
		
		
	}

	public static void  storeBenDao(String myAccNo , String benAccNo) {
			
			Connection connection = ConnectionProvider.getConnection();
			String query = "INSERT INTO BENIFICIARY VALUES(?,?)";
			
			
			try {
				PreparedStatement preparedStatement = connection.prepareStatement(query);
				preparedStatement.setString(1,myAccNo);
				preparedStatement.setString(2,benAccNo);
				preparedStatement.executeUpdate();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
		
	}
	
	public static void transferAmountDao(String myAccNo, String benAccNo,int amt){
		
		withdrawlDao(myAccNo, amt);
		depositeDao(benAccNo, amt);
		
		
		
		
	}

	/*public static void checkValidityBenificiary(String myAccNo, String benAccNo,int amt) {
		
		Connection connection = ConnectionProvider.getConnection();
		String query = "SELECT * FROM BENIFICIARY WHERE MYACCNO = ? AND BENACCNO = ?";
	
		String accmy=null;
		String accben=null;
		try {
			PreparedStatement preparedstatement = connection.prepareStatement(query);
			ResultSet resultset = preparedstatement.executeQuery();
	
			
			while(resultset.next()){
				
				accmy = resultset.getString(1);
				accben = resultset.getString(2);
				
			}
			
			if(accmy.equals(myAccNo) && accben.equals(benAccNo)){
					transferAmountDao(myAccNo, benAccNo, amt);
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}*/

	public static void addAccountIn(Customer customer) {
		
		Connection connection = ConnectionProvider.getConnection();
		String query = "INSERT INTO ACCOUNT VALUES(?,?,?)";
		
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1,customer.getId());
			preparedStatement.setString(2,customer.getAccount().getAccountNo());
			preparedStatement.setInt(3,customer.getAccount().getBalance());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
		
	
}

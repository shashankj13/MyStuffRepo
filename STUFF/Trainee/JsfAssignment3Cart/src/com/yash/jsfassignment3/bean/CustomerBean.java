package com.yash.jsfassignment3.bean;

import java.awt.event.ActionEvent;
import java.sql.ResultSet;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.yash.jsfassignment3.service.CustomerService;
import com.yash.jsfassignment3.service.CustomerServiceImpl;

@ManagedBean
@SessionScoped
public class CustomerBean {

	private String name;
	private int contact;
	private String email;
	private String address;
	private String userName;
	private String password;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getContact() {
		return contact;
	}
	public void setContact(int contact) {
		this.contact = contact;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	CustomerService customerService = new CustomerServiceImpl();
	public String register(){
		
		customerService.insertCustomer(this);
		return "login";
	}
	
	public String authenticate(){
		ResultSet rs = customerService.authenticateCustomer(userName, password);
		try{
			if(rs.next()){
				this.name=rs.getString("name");
				this.address=rs.getString("address");
				this.userName=rs.getString("username");
				this.password=rs.getString("password");
				this.email=rs.getString("email");
				this.contact=rs.getInt("contact");
			}else{
				System.out.println("no value in result set");
			}
		}catch(Exception e){}
		return "shopping";
	}
	
	public String logoutCustomer(){
		HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		session.invalidate();
		return "login";
	}
	
	public String getDisplayTotalPrice(ActionEvent e){
		System.out.println(e);
		return "deepak";
	}
	
}

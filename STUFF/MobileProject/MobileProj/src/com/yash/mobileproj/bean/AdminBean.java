package com.yash.mobileproj.bean;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import com.yash.mobileproj.domain.Admin;
import com.yash.mobileproj.domain.Customer;
import com.yash.mobileproj.service.AdminService;

@SessionScoped
@ManagedBean
public class AdminBean {
	
	 Admin admin = new Admin();
	 List<Customer> list;
	
	public List<Customer> getList() {
		return list;
	}

	public void setList(List<Customer> list) {
		this.list = list;
	}

	private String username;
	private String password;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	
	@Inject AdminService adminService;
	
	public String authenticateAdmin() {
	/*	System.out.println("Object Of Customer service :- " + adminService);
		System.out.println("VALUE FORM admin.getusername()"
				+ admin.getUsername());
		System.out.println("VALUE FORM admin.getpassword()"
				+ admin.getPassword());*/
		
			admin = adminService.authenticateAdmin(username, password);
			System.out.println("IN BEAN OF ADMIN GETTING NAME :- " +admin);
			if(admin==null)
			{
				return "adminlogin"; 
			}
			else{
				System.out.println("RS in bean of admin");
				return "adminwelcome";
			}
			
		
	}

	public String logoutAdmin(){
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);
		session.invalidate();
		return "adminlogin";
	}
	
	public String seeAllCustomer() throws SQLException{
		list = new ArrayList<Customer>();
		list = adminService.fetchAllCustomers();
		System.out.println(list);
		return null;
	}
	
	public String addNewMobile(){
		
		adminService.addProduct();
		
		return null;
	}
	
	public String deleteMobile(){
		
		return null;
	}
	public String seeAllReq(){
		
		return null;
	}
	
	
	
	
}

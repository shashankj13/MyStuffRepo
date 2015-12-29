package com.yash.mobileproj.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import com.yash.mobileproj.domain.Customer;
import com.yash.mobileproj.domain.MobileDetails;
import com.yash.mobileproj.service.CustomerService;

@ManagedBean
@SessionScoped
public class CustomerBean {
	
	@Inject
	MobileDetails mobileDetails;
	
	public MobileDetails getMobileDetails() {
		return mobileDetails;
	}

	public void setMobileDetails(MobileDetails mobileDetails) {
		this.mobileDetails = mobileDetails;
	}

	private Customer customer=new Customer();
	private String username;
	private String password;
	public String getM1url() {
		return m1url;
	}

	public void setM1url(String m1url) {
		this.m1url = m1url;
	}

	
	
	private String m1url = "/images/iphone6.jpg";
	
	private List<MobileDetails> md1; 
	private List<MobileDetails> md2; 
	private List<MobileDetails> md3; 
	

	public List<MobileDetails> getMd1() {
		return md1;
	}

	public void setMd1(List<MobileDetails> md1) {
		this.md1 = md1;
	}

	public List<MobileDetails> getMd2() {
		return md2;
	}

	public void setMd2(List<MobileDetails> md2) {
		this.md2 = md2;
	}

	public List<MobileDetails> getMd3() {
		return md3;
	}

	public void setMd3(List<MobileDetails> md3) {
		this.md3 = md3;
	}

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

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Inject
	CustomerService customerService;

	public String authenticateCustomer() {
			 customer = customerService.authenticateCustomer(username, password);
		

			if(customer==null)
			{
				return "customerlogin"; 
			}
			else{
				
				System.out.println("RS in bean" + customer.getUsername());
				System.out.println("RS in bean" + customer.getName());
				return "customerwelcome";
			}
		
	}
	
	public String addCustomer(){
		customerService.insertCustomer(customer);
		return "customerlogin";
	}
	
	public String logoutCustomer(){
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);
		session.invalidate();
		return "customerlogin";
	}
	
	/*public String getDetail(int i) throws Exception{
		if(i==1)
		md1 = customerService.getAllMobileDetails("apple");
		md2 = customerService.getAllMobileDetails("samsung");
		md3 = customerService.getAllMobileDetails("windows");
		System.out.println(md1);
		return null;
	}*/
	
	
	@PostConstruct
	public void init(){
		try {
			md1 = customerService.getAllMobileDetails("apple");
			md2 = customerService.getAllMobileDetails("samsung");
			md3 = customerService.getAllMobileDetails("windows");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getmd1Details(int id){
		for(MobileDetails md : md1){
			if(md.getId()==id){
				System.out.println("THIS IS ID IN C BEAN " + id);
				mobileDetails = md;
			}
		}
		System.out.println("IN MD :" +mobileDetails);
		return null;
	}
	
	

}

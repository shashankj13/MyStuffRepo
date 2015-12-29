package com.yash.jsfvc.bean;

import java.util.Date;

import javax.faces.bean.ManagedBean;

import javax.faces.bean.SessionScoped;

@SessionScoped
@ManagedBean()
public class PersonBean {
	
	private String name;
	private int salary;
	private Date doj;
	private String  product;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public Date getDoj() {
		return doj;
	}
	public void setDoj(Date doj) {
		this.doj = doj;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	

}

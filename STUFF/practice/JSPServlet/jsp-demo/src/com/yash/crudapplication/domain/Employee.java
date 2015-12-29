package com.yash.crudapplication.domain;

public class Employee {
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	
	private int employeeId;
	private String employeeName;
	private String employeeContact;
	private String employeeAddress;
	
	
	
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmployeeContact() {
		return employeeContact;
	}
	public void setEmployeeContact(String employeeContact) {
		this.employeeContact = employeeContact;
	}
	public String getEmployeeAddress() {
		return employeeAddress;
	}
	public void setEmployeeAddress(String employeeAddress) {
		this.employeeAddress = employeeAddress;
	}
	@Override
	public String toString() {
		return "Employee [employeeName=" + employeeName + ", employeeContact=" + employeeContact + ", employeeAddress="
				+ employeeAddress + "]";
	}
	
	
	

}

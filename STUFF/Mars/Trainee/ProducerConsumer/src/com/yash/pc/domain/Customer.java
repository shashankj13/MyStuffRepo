package com.yash.pc.domain;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Customer {
	private String name;
	private String city;
	private int contact;
	
	public Customer() {
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getContact() {
		return contact;
	}
	public void setContact(int contact) {
		this.contact = contact;
	}
	@Override
	public String toString() {
		return "Customer [name=" + name + ", city=" + city + ", contact=" + contact + "]";
	}

}

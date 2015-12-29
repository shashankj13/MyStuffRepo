package com.yash.ems.domain;

public class Enquiry {
	int enqid; //pk in table
	String name;
	String email;
	int userid; 
	int contact;
	StringBuilder courses;

	public int getEnqid() {
		return enqid;
	}
	public void setEnqid(int enqid) {
		this.enqid = enqid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getContact() {
		return contact;
	}
	public void setContact(int contact) {
		this.contact = contact;
	}
	public StringBuilder getCourses() {
		return courses;
	}
	public void setCourses(StringBuilder courses) {
		this.courses = courses;
	}
	
	
}

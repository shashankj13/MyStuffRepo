package com.yash.domain;

public class Enquiry {
	private int enquiryId;
	private String name;
	private int userId;
	private String email;
	private  int contact;
	private String course;
	public int getEnquiryId() {
		return enquiryId;
	}
	public void setEnquiryId(int enquiryId) {
		this.enquiryId = enquiryId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getContact() {
		return contact;
	}
	public void setContact(int contact) {
		this.contact = contact;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String string) {
		
		this.course = string;
	}
	@Override
	public String toString() {
		return "Enquiry [enquiryId=" + enquiryId + ", name=" + name
				+ ", userId=" + userId + ", email=" + email + ", contact="
				+ contact + ", course=" + course + "]";
	}
	
	

}

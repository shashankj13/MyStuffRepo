package com.yash.training.tmp.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author honey.merwani
 *
 */

public class Course implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int course_id;
	private String course_title;
	private String course_desc;
	private String reference;
	private int course_status;
	private int userId;
	private String button_value;
	private List<Heading> headingList = new ArrayList<>();
	
	public List<Heading> getHeadingList() {
		return headingList;
	}
	public void setHeadingList(List<Heading> headingList) {
		this.headingList = headingList;
	}
	public String getButton_value() {
		return button_value;
	}
	public void setButton_value(String button_value) {
		this.button_value = button_value;
	}
	public int getCourse_id() {
		return course_id;
	}
	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getCourse_title() {
		return course_title;
	}
	public void setCourse_title(String course_title) {
		this.course_title = course_title;
	}
	public String getCourse_desc() {
		return course_desc;
	}
	public void setCourse_desc(String course_desc) {
		this.course_desc = course_desc;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public int getCourse_status() {
		return course_status;
	}
	public void setCourse_status(int course_status) {
		this.course_status = course_status;
	}

}

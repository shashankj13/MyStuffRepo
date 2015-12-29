package com.yash.studentmanagement.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Marks extends Student {
	
	private int marks_id;
	private int student_id;
	private int standard;
	private String grade;
	
	public int getMarks_id() {
		return marks_id;
	}
	public void setMarks_id(int marks_id) {
		this.marks_id = marks_id;
	}
	public int getStudent_id() {
		return student_id;
	}
	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}
	public int getStandard() {
		return standard;
	}
	public void setStandard(int standard) {
		this.standard = standard;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	

}

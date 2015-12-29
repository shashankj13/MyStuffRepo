package com.yash.studentmanagement.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Student {

	public Student(){
		
	}
	
	private int student_id;
	private String name;
	private Marks marks;
	
	public Marks getMarks() {
		return marks;
	}
	public void setMarks(Marks marks) {
		this.marks = marks;
	}
	
	public int getStudent_id() {
		return student_id;
	}
	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}

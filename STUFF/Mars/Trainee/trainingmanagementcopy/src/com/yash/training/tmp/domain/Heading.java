package com.yash.training.tmp.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author honey.merwani
 *
 */

public class Heading {
	
	private String title;
	private String heading;
	private List<Subheading> subheadingList = new ArrayList<>();
	private int course_id;
	
	public int getCourse_id() {
		return course_id;
	}
	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}
	public List<Subheading> getSubheadingList() {
		return subheadingList;
	}
	public void setSubheadingList(List<Subheading> subheadingList) {
		this.subheadingList = subheadingList;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getHeading() {
		return heading;
	}
	public void setHeading(String heading) {
		this.heading = heading;
	}
	

}

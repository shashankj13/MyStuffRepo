package com.yash.training.tmp.domain;

/**
 * 
 * @author shashank.juneja
 *
 */

public class Subheading {
	private int heading_id;
	private String courseTitle;
	private String headingTitle;
	private String subheadingTitle;
	private String subheadingStatus;
	private int subHeading_id;
	
	
	
	
	public int getSubHeading_id() {
		return subHeading_id;
	}
	public void setSubHeading_id(int subHeading_id) {
		this.subHeading_id = subHeading_id;
	}
	public int getHeading_id() {
		return heading_id;
	}
	public void setHeading_id(int heading_id) {
		this.heading_id = heading_id;
	}
	public String getSubheadingStatus() {
		return subheadingStatus;
	}
	public void setSubheadingStatus(String subheadingStatus) {
		this.subheadingStatus = subheadingStatus;
	}
	public String getCourseTitle() {
		return courseTitle;
	}
	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}
	public String getHeadingTitle() {
		return headingTitle;
	}
	public void setHeadingTitle(String headingTitle) {
		this.headingTitle = headingTitle;
	}
	public String getSubheadingTitle() {
		return subheadingTitle;
	}
	public void setSubheadingTitle(String subheadingTitle) {
		this.subheadingTitle = subheadingTitle;
	}
	@Override
	public String toString() {
		return "Subheading [heading_id=" + heading_id + ", courseTitle=" + courseTitle + ", headingTitle="
				+ headingTitle + ", subheadingTitle=" + subheadingTitle + ", subheadingStatus=" + subheadingStatus
				+ ", subHeading_id=" + subHeading_id + "]";
	}
	
	

}

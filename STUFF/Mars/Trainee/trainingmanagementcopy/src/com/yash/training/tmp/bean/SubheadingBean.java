package com.yash.training.tmp.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import com.yash.training.tmp.domain.Subheading;
import com.yash.training.tmp.service.CourseServiceLocal;

/**
 * 
 * @author honey.merwani
 *
 */

@SessionScoped
@ManagedBean
public class SubheadingBean {
	private int course_id;
	private String course_title;
	private int heading_id;
	private String heading_title;
	private String subheading;
	private List<String> headinglist = new ArrayList<>() ;
	private List<String> courseListTitle = new ArrayList<>() ;
	private String subheading_status;
	
	
	public int getHeading_id() {
		return heading_id;
	}
	public void setHeading_id(int heading_id) {
		this.heading_id = heading_id;
	}
	public int getCourse_id() {
		return course_id;
	}
	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}
	public String getSubheading_status() {
		return subheading_status;
	}
	public void setSubheading_status(String subheading_status) {
		this.subheading_status = subheading_status;
	}
	public List<String> getCourseListTitle() {
		return courseListTitle;
	}
	public void setCourseListTitle(List<String> courseListTitle) {
		this.courseListTitle = courseListTitle;
	}

	@EJB
	CourseServiceLocal courseServiceLocal;
	
	public List<String> getHeadinglist() {
		return headinglist;
	}
	public void setHeadinglist(List<String> headinglist) {
		this.headinglist = headinglist;
	}
	public String getCourse_title() {
		return course_title;
	}
	public void setCourse_title(String course_title) {
		this.course_title = course_title;
	}
	public String getHeading_title() {
		HttpSession httpSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		int userid = (int) httpSession.getAttribute("userId");
		headinglist = courseServiceLocal.fetchHeadingTitle(userid);
		return heading_title;
	}
	public void setHeading_title(String heading_title) {
		this.heading_title = heading_title;
	}
	public String getSubheading() {
		return subheading;
	}
	public void setSubheading(String subheading) {
		this.subheading = subheading;
	}
	
	@PostConstruct
	public void getHeadingTitle(){
		HttpSession httpSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		int userid = (int) httpSession.getAttribute("userId");
		courseListTitle = courseServiceLocal.fetchCourseTitle(userid);
		
	}
	
	@Inject
	Subheading subheadingobj;
	public String storeSubheading(int btn){
	
		subheadingobj.setHeading_id(heading_id);
		subheadingobj.setSubheadingTitle(subheading);
		subheadingobj.setSubheadingStatus(subheading_status);
	
		courseServiceLocal.addSubHeading(subheadingobj);
		if(btn==1){
		return "createcourses";
		}
		return null;
	}
	
/*	public String storeAndAddSubheading(){
		subheadingobj.setHeadingTitle(heading_title);
		subheadingobj.setCourseTitle(course_title);
		subheadingobj.setSubheadingTitle(subheading);
		subheadingobj.setSubheadingStatus(subheading_status);
		
		courseServiceLocal.addSubHeading(subheadingobj);
		
		return null;
	
	}*/
	
	

}

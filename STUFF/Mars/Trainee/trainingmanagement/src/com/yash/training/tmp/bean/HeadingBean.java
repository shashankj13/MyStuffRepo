package com.yash.training.tmp.bean;

import java.util.ArrayList;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Inject;

import com.yash.training.tmp.domain.Heading;
import com.yash.training.tmp.service.CourseServiceLocal;
/**
 * 
 * @author shashank.juneja
 *
 */

@SessionScoped
@ManagedBean
public class HeadingBean {
	private List<Heading> detailedCourseHeadingList = new ArrayList<>();
	private String heading_title;
	private String course_title;
	private List<String> listTitle = new ArrayList<>() ;
	private int course_id;
	
	
	public List<Heading> getDetailedCourseHeadingList() {
		return detailedCourseHeadingList;
	}
	public void setDetailedCourseHeadingList(List<Heading> detailedCourseHeadingList) {
		this.detailedCourseHeadingList = detailedCourseHeadingList;
	}
	public int getCourse_id() {
		return course_id;
	}
	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}
	public String getHeading_title() {
		return heading_title;
	}
	public void setHeading_title(String heading_title) {
		this.heading_title = heading_title;
	}


	

	public String getCourse_title() {
		return course_title;
	}
	public void setCourse_title(String course_title) {
		this.course_title = course_title;
	}

	
	public List<String> getListTitle() {
		return listTitle;
	}
	public void setListTitle(List<String> listTitle) {
		this.listTitle = listTitle;
	}
	
	
	@EJB 
	CourseServiceLocal courseServiceLocal;
	
	/*@PostConstruct
	public void fetchCourseTitleBean(){
		HttpSession httpSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		int userid = (int) httpSession.getAttribute("userId");
		listTitle = courseServiceLocal.fetchCourseTitle(userid);
	}*/
	
	
	@Inject
	Heading heading;
	
	public String storeHeading(int val){
		System.out.println("----------------STORE HEADING CALLED--------------");
		heading.setTitle(heading_title);
		heading.setCourse_id(course_id);
		
		courseServiceLocal.addHeading(heading);
		System.out.println("----------------STORE HEADING ENDED--------------");
		if(val==1){
			return "createcourses";
			}
			return null;
	
	}
	
	/*public String storeAndAdd(){
		System.out.println("----------------STORE AND ADD CALLED--------------");
		heading.setHeading(heading_title);
		heading.setTitle(course_title);
		
		courseServiceLocal.addHeading(heading);
		System.out.println("----------------STORE AND ADD ENDED--------------");
		return null;
	
	}*/
	
	public void getHeadings(ValueChangeEvent e){
		System.out.println("prakhar");
		int course_id=Integer.parseInt(e.getNewValue().toString());
		System.out.println(course_id);
		detailedCourseHeadingList=courseServiceLocal.getAllHeadings(course_id);
		System.out.println(detailedCourseHeadingList);
		
	}

	
}

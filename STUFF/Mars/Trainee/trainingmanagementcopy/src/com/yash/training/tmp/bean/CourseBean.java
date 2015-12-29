package com.yash.training.tmp.bean;


import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import com.yash.training.tmp.domain.Course;
import com.yash.training.tmp.domain.Heading;
import com.yash.training.tmp.service.CourseServiceLocal;

/**
 * 
 * @author shashank.juneja
 *
 */

@ManagedBean
@SessionScoped
public class CourseBean {
	
	private int id;
	private String title;
	private String desc;
	private String ref;
	private boolean status=true;
	private int allActiveCoursesCount;
	private int allCurrentCoursesCount;
	private int userid;
	private int selectedCourse_id;
	private List<Course> courseList = new ArrayList<>();

	//private List<Course> detailedCourseList = new ArrayList<>();
	/*private List<Heading> detailedCourseHeadingList = new ArrayList<>();
	private List<Subheading> detailedCourseSubheadingList = new ArrayList<>();*/
	
	private Course course2;
	
	

	public Course getCourse2() {
		return course2;
	}

	public void setCourse2(Course course2) {
		this.course2 = course2;
	}

	public int getSelectedCourse_id() {
		return selectedCourse_id;
	}

	public void setSelectedCourse_id(int selectedCourse_id) {
		this.selectedCourse_id = selectedCourse_id;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public int getAllActiveCoursesCount() {
		HttpSession httpSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		userid = (int) httpSession.getAttribute("userId");
		allActiveCoursesCount = courseServiceLocal.getTotalActiveCourses(userid);
		return allActiveCoursesCount;
	}

	public void setAllActiveCoursesCount(int allActiveCoursesCount) {
		this.allActiveCoursesCount = allActiveCoursesCount;
	}

	public int getAllCurrentCoursesCount() {
		HttpSession httpSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		userid = (int) httpSession.getAttribute("userId");
		allCurrentCoursesCount = courseServiceLocal.getTotalCourses(userid);
		return allCurrentCoursesCount;
	}

	public void setAllCurrentCoursesCount(int allCurrentCoursesCount) {
		this.allCurrentCoursesCount = allCurrentCoursesCount;
	}



	public List<Course> getCourseList() {
		HttpSession httpSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		userid = (int) httpSession.getAttribute("userId");
		courseList = courseServiceLocal.getAllCoursesService(userid);
		return courseList;
	}

	public void setCourseList(List<Course> courseList) {
		this.courseList = courseList;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

	@Inject
	Course course;
	
	@EJB
	CourseServiceLocal courseServiceLocal;
	
	public String saveCourse() throws Exception{
		HttpSession httpSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		userid = (int) httpSession.getAttribute("userId");
		
		System.out.println(status);
		
		course.setCourse_desc(desc);
		course.setReference(ref);
		course.setCourse_title(title);
		course.setUserId(userid);
		
		if(status){
			course.setCourse_status(1);
		}
		
		if(!status){
			course.setCourse_status(0);
		}
		
		System.out.println("+++---------------------------" + desc + "-----------------------" + title);
		courseServiceLocal.createCourseService(course);
		desc=null;
		ref=null;
		title=null;
		
		return "createcourse.xhtml?msg=Saved & faces-redirect=true";
	}
	
	public String getAllCourses(){
				
		
		return "seecourses";
	}
	
	public String deleteSelectedCourses(){
		courseServiceLocal.deleteSpecificCourse(selectedCourse_id);
		return "seecourses";
	} 
	
	/*@PostConstruct
	public void getActiveAndAllCourses(){
		HttpSession httpSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		userid = (int) httpSession.getAttribute("userId");
		allActiveCoursesCount = courseServiceLocal.getTotalActiveCourses(userid);
		allCurrentCoursesCount = courseServiceLocal.getTotalCourses(userid);
		System.out.println(allActiveCoursesCount + allCurrentCoursesCount +"----------------------" ); } */
		
		
	
	
	public String changeStatusMethod(){
		System.out.println(selectedCourse_id+"------changeStatusmethod()------------");
		int receivedStatus = courseServiceLocal.getStatus(selectedCourse_id);
		courseServiceLocal.changeStatusMethod(receivedStatus,selectedCourse_id);
		return "seecourses";
	}
	
	public String showDetailedCourse(){	
		
		System.out.println("------showDEtailedCOURSE()------------" +selectedCourse_id );
		 course2 = courseServiceLocal.getAllDetails(selectedCourse_id);
		 System.out.println("-------------------------------SHOW DEATILED METHOD STARTED-------------------");
		 for( Heading list : course2.getHeadingList() ){
			 System.out.println("------------ LIST ----------" + list);
			 
		 }
		 System.out.println("-------------------------------SHOW DEATILED METHOD ENDED-------------------");
		return "showdetails";
	}
	
	
	

}

package com.yash.training.tmp.bean;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.commons.io.FilenameUtils;

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
	private boolean status = true;
	private int allActiveCoursesCount;
	private int allCurrentCoursesCount;
	private int userid;
	private int selectedCourse_id;
	private List<Course> courseList = new ArrayList<>();
	private int subheadingIdReceived;
	private String selectedCourseStatus;
	private Course course2;
	private List<Course> courseActiveList;
	
	@Inject
	Course course;
	
	@EJB
	CourseServiceLocal courseServiceLocal;

	private Part file;
	
	public Part getFile() {
		return file;
	}
	
	public void setFile(Part file) {
		this.file = file;
	}
	// private List<Course> detailedCourseList = new ArrayList<>();
	/*
	 * private List<Heading> detailedCourseHeadingList = new ArrayList<>();
	 * private List<Subheading> detailedCourseSubheadingList = new
	 * ArrayList<>();
	 */

	public int getSubheadingIdReceived() {
		return subheadingIdReceived;
	}

	public void setSubheadingIdReceived(int subheadingIdReceived) {
		this.subheadingIdReceived = subheadingIdReceived;
	}

	public String getSelectedCourseStatus() {
		return selectedCourseStatus;
	}

	public void setSelectedCourseStatus(String selectedCourseStatus) {
		this.selectedCourseStatus = selectedCourseStatus;
	}


	public List<Course> getCourseActiveList() {
		courseActiveList = courseServiceLocal.fetchTotalActiveCourses();
		return courseActiveList;
	}

	public void setCourseActiveList(List<Course> courseActiveList) {
		this.courseActiveList = courseActiveList;
	}

	public Course getCourse2() {
		course2 = courseServiceLocal.getAllDetails(selectedCourse_id);
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


	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public String saveCourse() throws Exception {
		HttpSession httpSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		userid = (int) httpSession.getAttribute("userId");

		System.out.println(status);

		course.setCourse_desc(desc);
		course.setReference(ref);
		course.setCourse_title(title);
		course.setUserId(userid);

		if (status) {
			course.setCourse_status(1);
		}

		if (!status) {
			course.setCourse_status(0);
		}

		System.out.println("+++---------------------------" + desc + "-----------------------" + title);
		courseServiceLocal.createCourseService(course);
		desc = null;
		ref = null;
		title = null;

		return "createcourse.xhtml?msg=Saved & faces-redirect=true";
	}

	public String getAllCourses() {

		return "seecourses";
	}

	public String deleteSelectedCourses() {
		courseServiceLocal.deleteSpecificCourse(selectedCourse_id);
		return "seecourses";
	}

	/*
	 * @PostConstruct public void getActiveAndAllCourses(){ HttpSession
	 * httpSession = (HttpSession)
	 * FacesContext.getCurrentInstance().getExternalContext().getSession(true);
	 * userid = (int) httpSession.getAttribute("userId"); allActiveCoursesCount
	 * = courseServiceLocal.getTotalActiveCourses(userid);
	 * allCurrentCoursesCount = courseServiceLocal.getTotalCourses(userid);
	 * System.out.println(allActiveCoursesCount + allCurrentCoursesCount
	 * +"----------------------" ); }
	 */

	public String changeStatusMethod() {
		System.out.println(selectedCourse_id + "------changeStatusmethod()------------");
		int receivedStatus = courseServiceLocal.getStatus(selectedCourse_id);
		courseServiceLocal.changeStatusMethod(receivedStatus, selectedCourse_id);
		return "seecourses";
	}

	public String showDetailedCourse() {

		System.out.println("------showDEtailedCOURSE()------------" + selectedCourse_id);
		course2 = courseServiceLocal.getAllDetails(selectedCourse_id);
		for (Heading list : course2.getHeadingList()) {
			System.out.println("------------ LIST ----------" + list);

		}
		return "showdetails";
	}

	public String showDetailedCourse2() {

		course2 = courseServiceLocal.getAllDetails(selectedCourse_id);
		System.out.println(course2);
		return "trainerdetails";
	}

	public String updateSelectedCourse() {
		System.out.println("------------------------UDDATE SELECTED COURSE--------- " + subheadingIdReceived + "------ "
				+ selectedCourseStatus);
		courseServiceLocal.changeCourseStatus(subheadingIdReceived, selectedCourseStatus);
		selectedCourseStatus = "";
		return null;
	}

	/*
	 * public void listenerCourseStatus(ValueChangeEvent e){
	 * selectedCourseStatus=(String)e.getNewValue().toString();
	 * 
	 * }
	 */


	/**
	 * UPLOAD A FILE
	 * @return
	 */
	public String uploadFileValue() {
		Part uploadedFile = getFile();
		File file = new java.io.File("D:/Mars/Trainee/trainingmanagement/WebContent/upload/");
		String abspath = file.getAbsolutePath();
		final Path destination = Paths.get(abspath + "/" + FilenameUtils.getName(getSubmittedFileName(uploadedFile)));
		InputStream bytes = null;
		if (null != uploadedFile) {
			try {
				bytes = uploadedFile.getInputStream();
				Files.copy(bytes, destination);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;

	}

	/**
	 * 
	 * @param filePart
	 * @return
	 */
	public static String getSubmittedFileName(Part filePart) {
		String header = filePart.getHeader("content-disposition");
		if (header == null)
			return null;
		for (String headerPart : header.split(";")) {
			if (headerPart.trim().startsWith("filename")) {
				return headerPart.substring(headerPart.indexOf('=') + 1).trim().replace("\"", "");
			}
		}
		return null;
	}

}

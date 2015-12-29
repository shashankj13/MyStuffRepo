package com.yash.training.tmp.service;

import java.util.List;

import javax.ejb.Local;

import com.yash.training.tmp.domain.Course;
import com.yash.training.tmp.domain.Heading;
import com.yash.training.tmp.domain.Subheading;

@Local
public interface CourseServiceLocal {

	public void createCourseService(Course course) throws Exception;
	public List<String> fetchCourseTitle(int userid);
	public void addHeading(Heading heading);
	public List<String> fetchHeadingTitle(int userid);
	public void addSubHeading(Subheading subheadingobj);
	public List<Course> getAllCoursesService(int userid);
	
	public int getTotalCourses(int userid);
	public int getTotalActiveCourses(int userid);
	public void changeStatusMethod(int selectedCourse_id, int selectedCourse_id2);
	
	public int getStatus(int selectedCourse_id);
	/*public List<Course> fetchDetailedCourse(int selectedCourse_id);
	public List<Heading> getHeadingDetailsFromCourseid(int selectedCourse_id);
	public List<Subheading> getSubheadingDetailsFromHeadingid(int selectedCourse_id);*/
	public Course getAllDetails(int selectedCourse_id);
	public void deleteSpecificCourse(int selectedCourse_id);
	public List<Heading> getAllHeadings(int course_id);
	public List<Course> fetchTotalActiveCourses();
	public void changeCourseStatus(int subheadingIdReceived, String selectedCourseStatus);
}

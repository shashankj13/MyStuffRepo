package com.yash.training.tmp.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import com.yash.training.tmp.domain.Course;
import com.yash.training.tmp.domain.Heading;
import com.yash.training.tmp.domain.Subheading;
import com.yash.training.tmp.util.DButil;

/**
 * Session Bean implementation class CourseService
 */
@Stateless
public class CourseService implements CourseServiceLocal {

	/**
	 * Default constructor.
	 */
	public CourseService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void createCourseService(Course course) throws Exception {
		String query = "INSERT INTO CREATECOURSE (COURSE_TITLE,COURSE_DESC,REFERENCE,COURSE_STATUS,USER_ID) VALUES ('"
				+ course.getCourse_title() + "' , '" + course.getCourse_desc() + "','" + course.getReference() + "','"
				+ course.getCourse_status() + "' , '" + course.getUserId() + "') ";
		System.out.println(query);
		DButil.update(query);

	}

	@Override
	public List<String> fetchCourseTitle(int userid) {
		String sql = "SELECT * FROM CREATECOURSE WHERE USER_ID="+userid;
		System.out.println("INSIDE COURSE SERIVE METHOD FETCHCOURSETITLE -----------" + userid);
		ResultSet resultSet = DButil.select(sql);
		List<String> list = new ArrayList<String>();

		try {
			while (resultSet.next()) {
				list.add((resultSet.getString("COURSE_TITLE")));
				System.out.println("----------------------------" + resultSet.getString("COURSE_TITLE"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public void addHeading(Heading heading) {
		String sql = "INSERT INTO HEADING (HEADING_TITLE,COURSE_ID) VALUES ('" + heading.getTitle() + "' , " + heading.getCourse_id()
				+ ")";
		System.out.println(sql);
		try {
			DButil.update(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public int getIDFromTitle(String title) {
		String sql = "SELECT COURSE_ID FROM CREATECOURSE WHERE COURSE_TITLE = '" + title + "'";
		System.out.println(sql);
		ResultSet resultSet = DButil.select(sql);
		int id = 0;
		try {
			while (resultSet.next()) {
				id = resultSet.getInt("COURSE_ID");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id;
	}

	@Override
	public List<String> fetchHeadingTitle(int userid) {

		String sql = "SELECT HEADING_TITLE FROM HEADING";
		ResultSet resultSet = DButil.select(sql);
		List<String> list = new ArrayList<String>();

		try {
			while (resultSet.next()) {
				list.add(resultSet.getString("HEADING_TITLE"));
				System.out.println("----------------------------" + resultSet.getString("HEADING_TITLE"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public void addSubHeading(Subheading subheadingobj) {
		
		
	String sql="Insert into subheading(subheading_title,heading_id,subheading_status)values('"+subheadingobj.getSubheadingTitle()+"',"+subheadingobj.getHeading_id()+",'"+subheadingobj.getSubheadingStatus()+"')";
		System.out.println(sql);
		try {
			DButil.update(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public int getIDFromTitleSubheading(String title) {
		String sql = "SELECT HEADING_ID FROM HEADING WHERE HEADING_TITLE = '" + title + "'";
		System.out.println(sql);
		ResultSet resultSet = DButil.select(sql);
		int id = 0;
		try {
			while (resultSet.next()) {
				id = resultSet.getInt("HEADING_ID");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id;
	}

	@Override
	public List<Course> getAllCoursesService(int userid) {

		String sql = "SELECT * FROM CREATECOURSE WHERE USER_ID = " + userid;
		ResultSet resultSet = DButil.select(sql);
		List<Course> clist = new ArrayList<>();
		try {
			while (resultSet.next()) {
				Course course = new Course();
				course.setCourse_id(resultSet.getInt("COURSE_ID"));
				course.setCourse_title(resultSet.getString("COURSE_TITLE"));
				course.setReference(resultSet.getString("REFERENCE"));
				course.setCourse_desc(resultSet.getString("COURSE_DESC"));
				course.setCourse_status(resultSet.getInt("COURSE_STATUS"));
				course.setUserId(resultSet.getInt("USER_ID"));

				if (resultSet.getInt("COURSE_STATUS") == 1) {
					course.setButton_value("Deactivate");
				}

				if (resultSet.getInt("COURSE_STATUS") == 0) {
					course.setButton_value("Activate");
				}
				clist.add(course);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return clist;
	}

	@Override
	public int getTotalCourses(int userid) {
		String sql = "SELECT COUNT(*) FROM CREATECOURSE WHERE USER_ID = " +userid;
		int totalRows = 0;
		ResultSet resultSet = DButil.select(sql);
		try {

			while (resultSet.next()) {
				totalRows = resultSet.getInt(1);
				System.out.println("GET TOTAL COURSES --------------------" + resultSet.getString("count(*)"));
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return totalRows;
	}

	@Override
	public int getTotalActiveCourses(int userid) {
		String sql = "SELECT COUNT(*) FROM CREATECOURSE WHERE COURSE_STATUS = 1 AND USER_ID =" + userid;
		int ActiveRows = 0;
		ResultSet resultSet = DButil.select(sql);
		try {
			while (resultSet.next()) {
				System.out.println("TOTAL ACTIVE ----------------" + resultSet.getString("count(*)"));
				ActiveRows = resultSet.getInt(1);
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ActiveRows;
	}

	@Override
	public void changeStatusMethod(int status, int selectedCourse_id) {
		String query = "UPDATE CREATECOURSE SET COURSE_STATUS = " + status + " WHERE COURSE_ID = " + selectedCourse_id;
		try {
			DButil.update(query);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public int getStatus(int selectedCourse_id) {
		String query = "SELECT COURSE_STATUS FROM CREATECOURSE WHERE COURSE_ID = " + selectedCourse_id;
		int status = 0;
		ResultSet resultSet = DButil.select(query);
		try {
			while (resultSet.next()) {
				if (resultSet.getInt(1) == 1) {
				} else {
					status = 1;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return status;
	}

	/*
	 * @Override public List<Course> fetchDetailedCourse(int selectedCourse_id)
	 * { String sql = "SELECT * FROM CREATECOURSE WHERE COURSE_ID = "
	 * +selectedCourse_id; ResultSet resultSet = DButil.select(sql);
	 * List<Course> detailedList = new ArrayList<>(); try { while
	 * (resultSet.next()) { Course course = new Course();
	 * course.setCourse_id(resultSet.getInt("COURSE_ID"));
	 * course.setCourse_title(resultSet.getString("COURSE_TITLE"));
	 * course.setReference(resultSet.getString("REFERENCE"));
	 * course.setCourse_desc(resultSet.getString("COURSE_DESC"));
	 * course.setCourse_status(resultSet.getInt("COURSE_STATUS"));
	 * course.setUserId(resultSet.getInt("USER_ID"));
	 * 
	 * if(resultSet.getInt("COURSE_STATUS") == 1){
	 * course.setButton_value("Deactivate"); }
	 * 
	 * if(resultSet.getInt("COURSE_STATUS") == 0){
	 * course.setButton_value("Activate"); } detailedList.add(course);
	 * 
	 * } } catch (SQLException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); }
	 * 
	 * return detailedList;
	 * 
	 * }
	 * 
	 * public List<Heading> getHeadingDetailsFromCourseid(int selectedCourse_id)
	 * { String sql = "SELECT * FROM HEADING WHERE COURSE_ID = "
	 * +selectedCourse_id; List<Heading> headingDetailsList = new ArrayList<>();
	 * ResultSet resultSet = DButil.select(sql); try { while (resultSet.next())
	 * { Heading heading = new Heading();
	 * heading.setHeading(resultSet.getString("HEADING_ID"));
	 * heading.setTitle(resultSet.getString("HEADING_TITLE"));
	 * headingDetailsList.add(heading); } } catch (SQLException e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); } return
	 * headingDetailsList; }
	 */

	/*
	 * List<Subheading> subheadingDetailsList = new ArrayList<>();
	 * 
	 * @Override public List<Subheading> getSubheadingDetailsFromHeadingid(int
	 * headID) { String sql = "SELECT * FROM SUBHEADING WHERE HEADING_ID = "
	 * +headID; ResultSet resultSet = DButil.select(sql); try { while
	 * (resultSet.next()) { Subheading subheading = new Subheading();
	 * subheading.setSubheadingStatus(resultSet.getString("SUBHEADING_STATUS"));
	 * subheading.setSubheadingTitle(resultSet.getString("SUBHEADING_TITLE"));
	 * subheadingDetailsList.add(subheading); } } catch (SQLException e) {
	 * e.printStackTrace(); } return subheadingDetailsList;
	 * 
	 * }
	 */

	public Course getAllDetails(int id) {

		List<Heading> headings;
		List<Subheading> subHeadings;

		Course course = new Course();
	
		Subheading subheading;
		String sql = "Select * from createcourse where course_id=" + id;
		System.out.println(sql);
		ResultSet resultSet = DButil.select(sql);
		try {
			while (resultSet.next()) {
				headings = new ArrayList<>();
				course.setCourse_id(resultSet.getInt("COURSE_ID"));
				course.setCourse_title(resultSet.getString("COURSE_TITLE"));
				course.setReference(resultSet.getString("REFERENCE"));
				course.setCourse_desc(resultSet.getString("COURSE_DESC"));
				course.setCourse_status(resultSet.getInt("COURSE_STATUS"));
				course.setUserId(resultSet.getInt("USER_ID"));

				if (resultSet.getInt("COURSE_STATUS") == 1) {
					course.setButton_value("Deactivate");
				}

				if (resultSet.getInt("COURSE_STATUS") == 0) {
					course.setButton_value("Activate");
				}

				sql = "select * from heading where course_id=" + id;
				System.out.println(sql);
				ResultSet resultSet3 = DButil.select(sql);
				while (resultSet3.next()) {
					System.out.println("INSIDE WHILE ____------------------------------------------------");
					Heading heading = new Heading();
					subHeadings = new ArrayList<>();
					heading.setHeading(resultSet3.getString("HEADING_ID"));
					heading.setTitle(resultSet3.getString("HEADING_TITLE"));
					headings.add(heading);
					System.out.println("ABOVE SELECT QUERY-------------------------");
					sql = "select * from subheading where heading_id= ' " + heading.getHeading() + " ' ";
					System.out.println(sql);
					ResultSet resultSet2 = DButil.select(sql);
					while (resultSet2.next()) {
						subheading = new Subheading();
						subheading.setSubheadingStatus(resultSet2.getString("SUBHEADING_STATUS"));
						subheading.setSubheadingTitle(resultSet2.getString("SUBHEADING_TITLE"));
						subHeadings.add(subheading);

					}
					heading.setSubheadingList(subHeadings);
				}

				course.setHeadingList(headings);

			}
		} catch (SQLException e) {
			System.out.println("hello");
		}

		return course;
	}

	@Override
	public void deleteSpecificCourse(int selectedCourse_id) {
		String sql = "DELETE FROM CREATECOURSE WHERE COURSE_ID = " + selectedCourse_id;
		try {
			DButil.update(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public List<Heading> getAllHeadings(int course_id) {
		List< Heading> headings=new ArrayList<>();
		Heading heading;
		String sql = "SELECT * FROM HEADING WHERE course_id="+course_id;
		System.out.println(sql);
		ResultSet resultSet=DButil.select(sql);
		try {
			while(resultSet.next()){
				heading=new Heading();
				heading.setHeading(resultSet.getInt(1)+"");
				heading.setTitle(resultSet.getString(2));
				heading.setCourse_id(resultSet.getInt(3));
				headings.add(heading);
			}resultSet.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return headings;
	}

}

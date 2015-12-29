package com.yash.studentmanagement.service;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import com.yash.studentmanagement.dao.StudentDao;
import com.yash.studentmanagement.model.Marks;
import com.yash.studentmanagement.model.Student;

public class StudentServiceImpl implements StudentService {

	@Inject StudentDao studentDao;
	
	
	/**
	 * OVERRIDE METHOD
	 * GET BY STUDENT_ID IN SERVICE
	 */
	@Override
	public Student getStudentById(int s_id) throws SQLException {
		String sql = "SELECT * FROM STUDENT WHERE STUDENT_ID = " +s_id;
		System.out.println(s_id);
		ResultSet rs = studentDao.select(sql);
		Student student = null;
		
		while(rs.next()){
			student = new Student();
			student.setStudent_id(rs.getInt("student_id"));
			student.setName(rs.getString("name"));
		}
		return student;
	}

	/**
	 * OVERRIDE METHOD
	 * GET BY STANDARD IN SERVICE
	 */
	@Override
	public List<Marks> getStudentByStandard(int standard) throws SQLException {
		String sql = "SELECT * FROM MARKS WHERE STANDARD = " +standard;
		ResultSet rs = studentDao.select(sql);
		Marks marks = null;
		List<Marks> list = new ArrayList<>();
		
		while(rs.next()){
			marks = new Marks();
			marks.setMarks_id(rs.getInt("marks_id"));
			marks.setGrade(rs.getString("grade"));
			marks.setStudent_id(rs.getInt("student_id"));
			marks.setStandard(rs.getInt("standard"));
			list.add(marks);
			
		}
		return list;
		
	}

	/**
	 * OVERRIDE METHOD
	 * GET BY MARKS_ID IN SERVICE
	 */
	@Override
	public Marks getStudentByMarks(int marks_id) throws SQLException {
		String sql = "SELECT * FROM MARKS WHERE MARKS_ID = " +marks_id;
		System.out.println("MARKS : " +sql);
		ResultSet rs = studentDao.select(sql);
		Marks marks = null;
		
		while(rs.next()){
			marks = new Marks();
			marks.setMarks_id(rs.getInt("marks_id"));
			marks.setGrade(rs.getString("grade"));
			marks.setStudent_id(rs.getInt("student_id"));
			marks.setStandard(rs.getInt("standard"));
			
		}
		return marks;
		
	}
	
	/**
	 *  OVERRIDE METHOD
	 *  GET GRADE 
	 */

	@Override
	public Marks fetchByGrade(int marks_id, int standard) throws SQLException {
		String sql = "SELECT GRADE FROM MARKS WHERE MARKS_ID ='" + marks_id+"' AND STANDARD = '" + standard + "'";
		ResultSet rs = studentDao.select(sql);
		Marks marks = null;
		while(rs.next()){
			marks = new Marks();
			marks.setGrade(rs.getString("grade"));
		
		}
		
		return marks;
	}

}

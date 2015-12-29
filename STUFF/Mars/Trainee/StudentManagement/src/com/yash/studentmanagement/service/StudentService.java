package com.yash.studentmanagement.service;


import java.sql.SQLException;
import java.util.List;

import com.yash.studentmanagement.model.Marks;
import com.yash.studentmanagement.model.Student;

public interface StudentService {

	public Student getStudentById(int student_id) throws SQLException;

	public List<Marks> getStudentByStandard(int standard) throws SQLException;

	public Marks getStudentByMarks(int marks_id) throws SQLException;

	public Marks fetchByGrade(int marks_id, int standard) throws SQLException;

}

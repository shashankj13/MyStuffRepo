package com.yash.studentmanagement.resource;

import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.yash.studentmanagement.model.Marks;
import com.yash.studentmanagement.model.Student;
import com.yash.studentmanagement.service.StudentService;

@Path("/studentresources")
public class StudentResource {
	
	@Inject StudentService studentService;
	
	/**
	 * GET BY STUDENTS 
	 */
	@GET
	@Path("/id/{student_id}")
	@Produces(MediaType.APPLICATION_XML)
	public Student getById(@PathParam("student_id") int student_id) throws Exception{
		return studentService.getStudentById(student_id);
	}
	
	/**
	 * GET BY STANDARD
	 */
	@GET
	@Path("/standard/{standard}")
	@Produces(MediaType.APPLICATION_XML)
	public List<Marks> getByStandard(@PathParam("standard") int standard) throws SQLException{
		 return studentService.getStudentByStandard(standard);
		
	}
	
	
	
	/**
	 * GET BY MARKS
	 */
	@GET
	@Path("/marks/{marks_id}")
	@Produces(MediaType.APPLICATION_XML)
	public Marks getByMarks(@PathParam("marks_id") int marks_id) throws SQLException{
		return studentService.getStudentByMarks(marks_id);
		
	}
	
	/**
	 * GET GRADE OF STUDENT WHERE MARKS AND STANDARD IS KNOWN
	 */
	@GET
	@Path("/marks/{marks_id}/standard/{standard}")
	@Produces(MediaType.APPLICATION_XML)
	public Marks fetchGrade(@PathParam("marks_id") int marks_id ,@PathParam("standard") int standard) throws SQLException{
		return studentService.fetchByGrade(marks_id,standard);
	}
	
	

}

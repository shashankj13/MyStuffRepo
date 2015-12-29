<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 align="center">Enquiry Management System</h1>
<h4>Welcome :   ${user.name}</h4>
	<form action="ControllerServlet">
		<input type="submit" name="action" value="ADD_ENQUIRY"/>
		<input type="submit" name="action" value="DELETE_ALLENQUIRY" >
	<br>
	
		<input type="submit" name="action" value="LogOut"/>
	<br><br>
	<table>
		<tr>
			
			<td>***</td>
			<td>EnquiryID</td>
			<td>Name</td>
			<td>UserID</td>
			<td>Email</td>
			<td>Contact</td>
			<td>Course</td>
			<td>Delete</td>
		</tr>
			<c:forEach var="list1" items="${list}" > 
		<tr>
			<td><input type="checkbox" name="delete" value="${list1.enquiryId}">
			<td>${list1.enquiryId}</td>
			<td>${list1.name}</td>
			<td>${list1.userId}</td>
			<td>${list1.email}</td>
			<td>${list1.contact}</td>
			<td>${list1.course}</td>
			<td><input type="submit" name="action" value="Delete">
		
		</tr>
			</c:forEach>
	
	</table>
	</form>
	
</body>
</html>
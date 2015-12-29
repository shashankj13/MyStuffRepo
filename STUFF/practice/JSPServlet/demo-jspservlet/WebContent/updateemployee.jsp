<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<c:forEach var="employee" items="${listemp}">
		<c:out value="${employee.employeeId}"></c:out>
	</c:forEach>

	<form action="EmployeeServlet" method="get">
		Enter YOUR ID: <input type="text" name="id"><br> Enter
		New Name: <input type="text" name="name"><br> Enter New
		City: <input type="text" name="city"><br> 
		<input type="submit" value="Modify" name="a"> 
		
		<a href="index.jsp"> GO BACK </a>
	</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<center>
	<h3><c:out value="${success}"></c:out></h3>
	<h3><c:out value="${value}"></c:out></h3>
		<h1>Login Form</h1>
		<form action="LoginActionServlet">
		
			<table>
				<tr>
					<td>UserName :  </td>
					<td><input type="text" name="userName"> </td>
				</tr>
				<tr>
					<td>Password :  </td>
					<td><input type="text" name="password"> </td>
				</tr>
				<tr>
					<td><a href="Registration.jsp">Register</a></td>
					<td> <input type="submit" value="Login"> </td>
				</tr>
			</table>
		</form>
	</center>

</body>
</html>
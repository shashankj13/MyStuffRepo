<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<%@ taglib uri="/Demo" prefix="demo"%>
<body>
	<form action="ControllerServlet">
		<table border=1>
			<tr>
				<td>ENTER Name:</td>
				<td><demo:form name="name" type="text" value="" /></td>
			</tr>

			<tr>
				<td>ENTER City:</td>
				<td><demo:form name="city" type="text" value="" /></td>
			</tr>

			<tr>
				<td>ENTER Id:</td>
				<td><demo:form name="id" type="text" value="" /></td>
			</tr>

			<tr>
				<td colspan=2 align="center"><input type="submit" value="CLICK"></td>
			</tr>
		</table>
	</form>
</body>
</html>
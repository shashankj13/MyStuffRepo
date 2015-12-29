<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center>
		<form action="RegistrationActionServlet">
			<h1>Registration Form</h1>
			<table>
				<tr>
					<td>NAME: </td>
					<td><input type="text" name="name"></td>
				</tr>
				<tr>
					<td>Email-ID: </td>
					<td><input type="text" name="email"></td>
				</tr>
				<tr>
					<td>type: </td>
					<td><input type="text" name="type"></td>
				</tr>
				<tr>
					<td>Status : </td>
					<td><input type="text" name="status"></td>
				</tr>
				<tr>
					<td>UserName : </td>
					<td><input type="text" name="userName"></td>
				</tr>
				<tr>
					<td>Password : </td>
					<td><input type="text" name="password"></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="Submit"></td>
				</tr>
			</table>
		</form>
	</center>
</body>
</html>
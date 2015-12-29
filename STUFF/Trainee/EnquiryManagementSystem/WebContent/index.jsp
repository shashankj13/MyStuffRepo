<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<style>
table {
	margin-top: 150px;
}
</style>


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="lightblue">
	<center>
		<form method="GET" action="LoginActionServlet">
			<table border="1" height="300px" width="500px">
				<tr>
					<td colspan="2" align="center">
						<h1>WELCOME</h1>

					</td>
				</tr>

				<tr>
					<td colspan="2" align="center">
						<h3>LOGIN FORM</h3>
					</td>
				</tr>

				<tr>
					<td align="center">Enter Username :</td>
					<td align="center"><input class="h" type="text"
						name="username"></td>
				</tr>

				<tr>
					<td align="center">Enter Password :</td>
					<td align="center"><input class="h" type="password"
						name="password"></td>
				</tr>

				<tr>
					<td align="center"><input class="h" type="submit"
						value="LOGIN" name="login"></td>
					<td><center>
							<a href="register.jsp"> new User?Register</a>
						</center></td>
				</tr>

			</table>
		</form>
	</center>
</body>
</html>
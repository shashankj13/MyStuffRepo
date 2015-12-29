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
		<form method="GET" action="EnquiryServlet">
			<table border="1" height="300px" width="500px">
				<tr>
					<td colspan="3" align="center">
						<h1>ENQUIRY PAGE</h1>
					</td>
				</tr>

				<tr>	
					<td align="center">Enter Name :</td>
					<td align="center" colspan="2"><input class="h" type="text" name="name">
					</td>
				</tr>

				<tr>
					<td align="center">Enter email :</td>
					<td align="center" colspan="2"><input class="h" type="text" name="email">
					</td>
				</tr>

				<tr>
					<td align="center">Enter contact :</td>
					<td align="center" colspan="2"><input class="h" type="text" name="contact">
					</td>
				</tr>

				<tr>
					<td align="center" colspan="2">SELECT COURSES :</td>
					<td align="center">
						<input type="checkbox" name="cb" value="core"> CORE JAVA<br>
						<input type="checkbox" name="cb" value="advance"> ADVANCE<br>
						<input type="checkbox" name="cb" value="spring"> SPRING<br>
						<input type="checkbox" name="cb" value="html">HTML<br>
						<input type="checkbox" name="cb" value="css"> CSS<br>
					
					
					</td>
				</tr>

				<tr>
					<td align="center" colspan="3"><input class="h" type="submit"
						value="SUBMIT"></td>

				</tr>

			</table>
		</form>
	</center>

</body>
</html>
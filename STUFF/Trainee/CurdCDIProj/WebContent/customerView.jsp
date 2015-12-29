<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@
		taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
body {
	align: center;
}


 #delete {
	height: 100px;
	width: 200px;
	border: 1px solid;
	margin-left: 200px;
}
#insert {
	height: 100px;
	width: 200px;
	border: 1px solid;
}
#update {
	height: 100px;
	width: 200px;
	border: 1px solid;
} 
#print {
	height: 250px;
	width: 300px;
	border: 1px solid;
}

</style>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="lightblue">
	<form action="CustomerServlet" method="get">
		<table>
			<tr>
				<td><input type="submit" name="Submit" value="Select"></td>
				<td><input type="submit" name="Submit" value="Delete"></td>
				<td><input type="submit" name="Submit" value="Insert"></td>
				<td><input type="submit" name="Submit" value="Update"></td>
			<tr>
		</table>
		

	<table id="delete">
		<tr>
			<td> Enter Id : <input type="text" name="deleteId">
		</tr>
	</table>
	
	<table id="update">
		<tr>
			<td> Enter Old Id : <input type="text" name="updateIdOld">
			<td> Enter New Id:  <input type="text" name="updateIdNew">
		</tr>
	</table>
	
	<table id="insert">
		<tr>
			<td> Enter Id : <input type="text" name="id">
			<td> Enter Name:  <input type="text" name="name">
			<td> Enter City:  <input type="text" name="city">
		</tr>
	</table>
	
	</form>

	<div id="print">
		<table>
			<tr>
				<td>ID</td>
				<td>NAME</td>
				<td>CITY</td>
			</tr>

			<c:forEach var="list" items="${list}">
				<tr>
					<td>${list.customerId}</td>
					<td>${list.customerName}</td>
					<td>${list.customerCity}</td>
				</tr>
			</c:forEach>
		</table>
	</div>

</body>
</html>
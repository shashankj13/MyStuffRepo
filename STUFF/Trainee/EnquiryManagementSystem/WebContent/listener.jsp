<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
table {
	align: center;
	margin-top: 150px;
	border: 1px solid gray;
}
</style>


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="lightblue">
	<form action="index.jsp">
		<input type="submit" value="logout" name="logout">
	</form>
	<form action="enquiry.jsp">
		<table>
			<tr>
				<td align="center" colspan="2"><input class="h" type="submit"
					value="ADD ENQUIRY"></td>
			</tr>

			<tr>
				<td>ENQID</td>
				<td>NAME</td>
				<td>USERID</td>
				<td>EMAIL</td>
				<td>CONTACT</td>
			</tr>

			<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
			<c:forEach var="list" items="${ list }">
				<tr>

					<td><c:out value="${list.enqid}"></c:out></td>
					<td><c:out value="${list.name}"></c:out></td>
					<td><c:out value="${list.userid}"></c:out></td>
					<td><c:out value="${list.email}"></c:out></td>
					<td><c:out value="${list.contact}"></c:out></td>

				</tr>
			</c:forEach>

		</table>

	</form>

</body>
</html>
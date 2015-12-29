<%@page import="com.yash.domain.Customer"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="lightblue">
	<center>

		<%-- <%
			List<Customer> customerList = (List<Customer>) request.getAttribute("customer");
		%> --%>
		<h1>Customer Details</h1>





		<table border="1">
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>City</th>
				<th>Mobile</th>
			</tr>
			<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
				<c:forEach var="customer" items="${customer}">
			<tr>
				
					<td><c:out value="${customer.id}"></c:out></td>
					<td><c:out value="${customer.name}"></c:out></td>
					<td><c:out value="${customer.city}"></c:out></td>
					<td><c:out value="${customer.mobile}"></c:out></td>
				
			</tr>
			</c:forEach>
			<%-- <%
				for (Customer customer : customerList) {
			%>
			<tr>
				<td><%=customer.getId()%></td>
				<td><%=customer.getName()%></td>
				<td><%=customer.getCity()%></td>
				<td><%=customer.getMobile()%></td>
			</tr>
			<%}%> --%>
		</table>

	</center>
</body>
</html>
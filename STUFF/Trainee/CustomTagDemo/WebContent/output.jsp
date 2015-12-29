<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<style>

table{
border : 2px solid green ; 
align : center;
}

td,tr {
align:center;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="lightblue">

<table>
<tr>
<td>NAME</td>
<td> ${customer.name} </td>
</tr>

<tr>
<td> ID </td>
<td>  ${customer.id} </td>
</tr>

<tr>
<td> CITY </td>
<td> ${customer.city} </td>
</tr>

</table>

 
 

</body>
</html>
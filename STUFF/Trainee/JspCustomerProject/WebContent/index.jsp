<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Customer</title>

<style>
.h:hover {
	background-color: yellow;
}

.blue {
	border: 2px solid blue;
}
</style>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.js"></script>
	<script type="text/javascript">
	$(document).ready(function() {
		$(':input').click(function() {
			$(this).addClass('blue');
		});

	});
</script>

</head>
<body bgcolor="lightblue">
	<center>
		<form method="GET" action="ControllerServlet">
			<table border="1" height="300px" width="500px">
				<tr>
					<td colspan="2" align="center">
						<h1>WELCOME</h1>
					</td>
				</tr>

				<tr>
					<td colspan="2" align="center">
						<h3>SEARCH CUSTOMER BY ID</h3>
					</td>
				</tr>

				<tr>
					<td align="center">Enter Id :</td>
					<td align="center"><input class="h" type="text" name="val">
					</td>
				</tr>

				<tr>
					<td colspan="2" align="center"><input class="h" type="submit"
						value="Search"></td>
				</tr>



			</table>
		</form>
	</center>
</body>
</html>
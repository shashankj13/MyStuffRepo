<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script>
function loadDoc() {
	var show = document.getElementById('val');
	var id = show.value.toString();
	
  var xhttp;
  if (window.XMLHttpRequest) {
    xhttp = new XMLHttpRequest();
    } else {s
    
    xhttp = new ActiveXObject("Microsoft.XMLHTTP");
  }
  xhttp.onreadystatechange = function() {
	 
			if (xhttp.readyState == 4 && xhttp.status == 200) {
				var emp = eval(xhttp.responseText);
				document.getElementById("demo").innerHTML = emp;
				
				
			}
		}
		xhttp.open("GET", "ControllerServlet?id="+id, true);
		xhttp.send();
	}
</script>

</head>
<body>



	
	ENTER ID :
	<input type="text" id="val">
	<button type="button" onclick="loadDoc()">Search</button>
	
		<table border=1>
			<tr><td>CONTACT ID NAME </td></tr>
			<tr id="demo"></tr>
		</table>
	
	
</body>
</html>
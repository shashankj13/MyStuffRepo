
<%@ page language="java" contentType="text/html; charset=EUC-KR"
       pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Show All Users</title>
 
 
<script>
       function searchEmployee() {
              var xmlhttp;
              var str = document.getElementById("txtName").value;
              if (window.XMLHttpRequest) {// IE7+, Firefox, Chrome, Opera, Safari
                     xmlhttp = new XMLHttpRequest();
              } else {// IE6, IE5
                     xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
              }
 
              xmlhttp.onreadystatechange = function() {
                          
                     if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
                           alert(xmlhttp.responseText);
                           var emp = eval(xmlhttp.responseText);
                    
                          
                           var tbl = document.getElementById("tblGrid").getElementsByTagName("tbody")[0];
                           tbl.innerHTML = "";
                           var row;
                           var arr = new Array();
                           for (i = 0; i < emp.length; i++) {
 
                                  row = tbl.insertRow(-1);
 
                                  var cell1 = row.insertCell(0);
                                  var cell2 = row.insertCell(1);
                                  var cell3 = row.insertCell(2);
                                  var cell4 = row.insertCell(3);
                                  cell1.innerHTML = emp[i].emp_id;
                                  cell2.innerHTML = emp[i].emp_name;
                                  cell3.innerHTML = emp[i].emp_desig;
                                  cell4.innerHTML = emp[i].emp_loc;
 
                           }
                     }
              }
              xmlhttp.open("POST", "EmployeeController?action=searchUser&str=" + str,false);
              xmlhttp.send();
       }
</script>
</head>
<body>
      
       <div align="center">
              <form method="get" action="EmployeeController">
                     <input type="text" value="" id="txtName" />&nbsp;<input
                           type="button" id="subBtn" value="SEARCH" onclick="searchEmployee();" />
              </form>
       </div>
       <br />
       <br />
 
 
       <table border=1 id="tblGrid" align="center">
              <thead>
                     <tr>
                           <th>Employee Id</th>
                           <th>Employee Name</th>
                           <th>Designation</th>
                           <th>Location</th>
                     </tr>
              </thead>
              <tbody>
 
              </tbody>
       </table>
       <br />
       <br />
       <a href="javascript:history.back();">Back</a>
</body>
</html>

<%@page import="nit.com.bo.Owner"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
</head>
<body>
<%
   Owner ow = (Owner)request.getAttribute("ow");
%>
   <form action="updateowner" method="post">
 USERID <input  name="userid" type="text" value="<%=ow.getId()%>"><br> 
USERNAME<input  name="username" type="text" value="<%=ow.getUsername()%>"><br>
PASSWORD<input name="password" "type="text"  value="<%=ow.getPassword()%>"><br>
MOBILE<input name="mobile" type="text" value="<%=ow.getMobile()%>"><br>
EMAIL<input  name="email" type="text" value="<%=ow.getEmail()%>"><br>
GENDER<input name="gender" "type="text"  value="<%=ow.getGender()%>"><br>
ADDRESS<input name="address" type="text" value="<%=ow.getAddress()%>"><br>
<input type="submit" value="update"> 	 </form>
 
</body>
</html>
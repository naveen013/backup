<%@include file="Header.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<f:view>
<% String message = (String)request.getAttribute("regmes"); %>
<center>
<h3>Congratulations! You have successfully sign up.</h3><br>
<table>
<h3>
<tr>Welcome To Student Hub</tr>
<tr><%=message %></h3></tr>
</table>
</center>
</f:view>
</body>
</html>
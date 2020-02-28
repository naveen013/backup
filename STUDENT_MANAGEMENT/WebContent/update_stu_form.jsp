<%@include file="header.jsp" %>
<%@page import="sis.com.bo.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<%
   Student stu  = (Student)request.getAttribute("stu");
%>

<form action="updatestu" method="post">
ID <input  name="stuid" type="text" value="<%=stu.getId()%>" readonly="readonly"><br> 
NAME<input  name="stuname" type="text" value="<%=stu.getName()%>"><br>
EMAIL<input name="stuemail" "type="text"  value="<%=stu.getEmail()%>"><br>
BRANCH<input name="stubranch" type="text" value="<%=stu.getBrachId()%>" readonly="readonly"><br>
<input type="submit" value="update"> 	
</form>
</body>
</html>
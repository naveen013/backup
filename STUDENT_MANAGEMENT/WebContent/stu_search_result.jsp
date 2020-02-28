<%@page import="sis.com.bo.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
   <%
     Student stu = (Student) request.getAttribute("stu");
   %>
   <fieldset><legend>STUDENT DETAIL</legend>
   ID:<%=stu.getId() %><br>
   NAME:<%=stu.getName() %> <br>
   EMAIL:<%=stu.getEmail() %><br>
   BRANCH:<%=stu.getBrachId() %>
   
   </fieldset>

</body>
</html>
<%@page import="nit.com.bo.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
  <%
        Student stu = (Student)request.getAttribute("stu");
  %>
    <fieldset><legend>Student Detail</legend>
    Roll No:<%=stu.getRollno() %><br>
    Name   :<%=stu.getName() %><br>
    Enrollment No:<%=stu.getEnrollmentno() %><br>
    Semester:<%=stu.getSem() %><br>
    Course:<%=stu.getCourse() %><br>
    Branch:<%=stu.getBranch() %><br>
    Email:<%=stu.getEmail() %><br> 
    </fieldset>
    <a href ="home.jsp" >back to home</a>

</body>
</html>
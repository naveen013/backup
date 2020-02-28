<%@page import="nit.com.bo.Student"%>
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
<fieldset style="width:270px;"><legend>Update Student form</legend>
<form action="Post">
Enter Roll No:&nbsp;&nbsp;<input type="number" name="Roll_no" min=1722301 max=17223084><br><br>
Name:&nbsp;&nbsp;<input type="text" name="Stu_Name"><br><br>
Enrollment:&nbsp;&nbsp;<input type="number" name="stu_enrollment_no"><br><br>
Semester:&nbsp;&nbsp;<input type="number" name="Semester" min=1 max=5><br><br>
Course:&nbsp;&nbsp;<input type="text" name="course"><br><br>
Branch:&nbsp;&nbsp;<input type="text" name="Branch"><br><br>
Email:&nbsp;&nbsp;<input type="email" name="email"><br><br>
<input type="submit" value="update"><br>
</form>
</fieldset>

</body>
</html>
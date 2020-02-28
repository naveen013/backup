<%@page import="stu.com.bo.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
       <%
   Student stu  = (Student)request.getAttribute("stu");
      
%>
         <fieldset style="width:270px;"><legend align="center"><b>Update Student</b></legend>
   <form action="add_stu" align="center" height=30% width=40%>
   
      ID:&nbsp;&nbsp;&nbsp;
      <input type="number" name="id" min=10 max=100 value=<%=stu.getId() %>>><br>
         First Name:&nbsp;&nbsp;&nbsp;;<input type="text" name="first_name" value=<%=stu.getFirstName() %>>><br>
Last Name:&nbsp;&nbsp;&nbsp;<input type="text" name="last_name" value=<%=stu.getLastName() %>>><br>
     Sex:&nbsp;&nbsp;&nbsp;     
  <input type="radio" name="sex" value="male" value=<%=stu.getSex() %>> Male
  <input type="radio" name="sex" value="female" value=<%=stu.getSex() %>>> Female<br>
       Birth Date:&nbsp;&nbsp;&nbsp;<input type="date" name="birthdate" value=<%=stu.getBirthDate() %>>><br>
       Phone:&nbsp;&nbsp;&nbsp;<input type="number" name="phone" value=<%=stu.getPhone() %>>><br>
        Address:&nbsp;&nbsp;&nbsp;<input type="text" name="Address" value= <%=  stu.getAddress()%>> <br>
    <input type="submit" value="update"><br>
</form>
</fieldset>
</body>
</html>
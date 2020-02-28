<%@page import="nit.com.bo.User"%>
<%@page import="nit.com.bo.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
  
  <% 
    Object obj = request.getAttribute("stulist");
    List<Student>list = (List<Student>)obj;
    %>
    Tottal Student = <%=list.size() %>
    <table border="1" bgcolor="pink" align="center">
    <caption><b>Student List:</b></caption>
    <tr>
    <th>ROLL_NO</th>
    <th>NAME</th>
    <th>ENROLLMENT_NO</th>
    <th>SEMESTER</th>
    <th>COURSE</th>
    <th>BRANCH</th>
    <th>EMAIL</th>
    </tr>
   <%for(Student stu:list) {%>
   <tr>
   <td><%=stu.getRollno() %></td>
   <td><%=stu.getName() %></td>
   <td><%=stu.getEnrollmentno() %></td>
   <td><%=stu.getSem() %></td>
   <td><%=stu.getCourse() %></td>
   <td><%=stu.getBranch() %></td>
   <td><%=stu.getEmail() %></td>
   <td>
      <a href="#">View</a>
      <a href="updatestu?sturollno=<%=stu.getRollno() %>">Update</a>
        <a href="delstu?sturollno=<%=stu.getRollno() %>">Delete</a>
   </tr>
   <%} %>
    
    </table>
    <a href="home.jsp">Back To Home</a>
   

</body>
</html>
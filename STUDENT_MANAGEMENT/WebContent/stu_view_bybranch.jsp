<%@include file="header.jsp" %>
<%@page import="java.util.List"%>
<%@page import="sis.com.bo.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
    <a href="home.jsp">BACK TO HOME</a>
   <hr>
  <%
     List<Student> list  = (List<Student>)  request.getAttribute("stulist");

   %>
<h1>TOTAL STUDENT : <%=list.size() %></h1>

 <table border="1" width="100%">
   <caption>ALL STUDENT LIST BY BRANCH</caption>
  <tr>
   <th>ID</th>
   <th>NAME</th>
   <th>EMAIL</th>
   <th>BRANCHID</th>
  </tr>
  
  <%for(Student stu : list){ %>
  	
  	<tr>
   <td><%=stu.getId() %></td>
   <td><%=stu.getName() %></td>
   <td><%=stu.getEmail() %></td>
   <td><%=stu.getBrachId() %></td>
   <td>
      <a href="#">View</a>
      <a href="#">Update</a>
      <a href="#">Delete</a>
     </td>
  </tr>
  	
  <%} %>
  

</body>
</html>
<%@page import="java.util.List"%>
<%@page import="stu.com.bo.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<title>Insert title here</title>
</head>
<body bgcolor="skyblue">

     
  <% 
    Object obj = request.getAttribute("stulist");
    List<Student>list = (List<Student>)obj;
    %>
    Tottal Student = <%=list.size() %>
        <table border="1" bgcolor="pink" align="center">
    <caption><b>Student List:</b></caption>
    <tr>
    <th>ID</th>
    <th>FIRST NAME</th>
    <th>LAST NAME</th>
    <th>SEX</th>
    <th>BIRTHDAY</th>
    <th>PHONE </th>
    <th>ADDRESS </th>
    </tr>
   <%for(Student stu:list) {%>
   <tr>
   <td><%=stu.getId() %></td>
   <td><%=stu.getFirstName() %></td>
   <td><%=stu.getLastName() %></td>
   <td><%=stu.getSex() %></td>
   <td><%=stu.getBirthDate() %></td>
   <td><%=stu.getPhone() %></td>
   <td><%=stu.getAddress() %></td>
   <td>
         <a href="#">View</a>
      <a href="updatestu?stuid=<%=stu.getId() %>">Update</a>
        <a href="delstu?stuid=<%=stu.getId() %>">Delete</a>
       </tr> 
   <%} %>
    
    </table>
    <a href="home.jsp">Back To Home</a>
</body>
</html>
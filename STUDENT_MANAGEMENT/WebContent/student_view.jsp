<%@include file="header.jsp" %>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="sis.com.bo.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
     <a href="home.jsp">Back to home</a>
     <%
        Object obj = request.getAttribute("stulist");
       List<Student>list = (List<Student>)obj;
       User user =null;
     %>
     Tottal Student = <%=list.size() %>
     <table border="1">
     <caption> All Student List</caption>
     <tr>
     <th>ID</th>
     <th>NAME</th>
     <th>EMAIL</th>
     <th>BRANCH ID</th>
     <th>ACTION</th>
     </tr>
     <%for(Student stu:list) { %>
     <tr>
     <td><%=stu.getId() %></td>
     <td><%=stu.getName() %></td>
     <td><%=stu.getEmail() %></td>
    <td><%=stu.getBrachId() %></td>
    
      <td>
      <a href="#">View</a>
      <%if(user!=null && user.getRole().equals("super")){%>
      <a href="updatestu?stuid=<%=stu.getId()%>">Update</a>
      <a href="delstu?stuid=<%=stu.getId()%>">Delete</a>
      <%}else  if( user!=null && user.getRole().equals("admin")){%>
	      <a href="updatestu?stuid=<%=stu.getId()%>">Update</a>
     <%} %>
     </tr> 
     <%} %>
     </table>
     
</body>
</html>
<%@include file="header.jsp" %>
<%@page import="sis.com.bo.Branch"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
    <a href="home.jsp">back to home</a>
<hr>


<%
    Object obj  = request.getAttribute("branchlist");
   List<Branch> list  = (List<Branch>)obj;
%>
how many branch  = <%=list.size() %>
 <table border="1">
   <caption>ALL branch List</caption>
  <tr>
   <th>ID</th>
   <th>NAME</th>
   <th>HOD</th>
  </tr>
  
  <%for(Branch branch :list){ %>
  <tr>
   <td><%=branch.getId() %></td> 
   <td><%=branch.getName() %></td>
   <td><%=branch.getHod() %></td>
  </tr>
  
   <%} %>
  
  
 </table>
</body>
</html>
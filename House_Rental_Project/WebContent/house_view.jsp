<%@page import="nit.com.bo.House"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<title>Insert title here</title>
</head>
<body bgcolor="pink">
     <a href="home.jsp">Back to home</a>
     <%
        Object obj = request.getAttribute("houselist");
       List<House>list = (List<House>)obj;
     %>
     <h2 align="center">Tottal House = <%=list.size() %></h2>
     <table border="1" align="center">
     <caption> All house List</caption>
     <tr>
     <th>name</th>
     <th>LOCATION</th>
     <th>CATEGORY</th>
     <th>BEDROOM</th>
     <th>EMAIL</th>
     <th>MOBILE</th>
     </tr>
     <%for(House house:list) { %>
     <tr>
     <td><%=house.getName()%></td>
     <td><%=house.getLocation() %></td>
     <td><%=house.getCategory() %></td>
    <td><%=house.getBedroom() %></td>
    <td><%=house.getEmail() %></td>
    <td><%=house.getMobile() %></td>
    <td>
      <a href="#">View</a>
     </tr> 
     <%} %>
     </table>
</body>
</html>
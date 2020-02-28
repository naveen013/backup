<%@page import="java.util.List"%>
<%@page import="nit.com.bo.House"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
</head>
<body bgcolor="lightgray" text="black">
  <%
      Object obj = request.getAttribute("foundMsg");
  List<House>list = (List<House>)obj;
  %>
      <h3 align="center"></>Total Owner= <%=list.size() %></h3>
<table border="1px" cellpadding="0" cellspacing="0px"  width="90%" align="center">
<tr height="50px" align="center">
<td width="200px"><b>Name</b></td>
<td width="200px"><b>Location</b></td>
<td width="200px"><b>Category</b></td>
<td width="200px"><b>Bedroom</b></td>
<td width="200px"><b>Email</b></td>
<td width="200px"><b>Mobile</b></td>
<td width="200px"><b>Picture</b></td>
</tr>
<%
for(House house:list){%>
<tr align="center">
<td><%=house.getName()%></td>
<td><%=house.getLocation()%></td>
<td><%=house.getCategory()%></td>
<td><%=house.getBedroom()%></td>
<td><%=house.getEmail()%></td>
<td><%=house.getMobile()%></td>

<td ><img src="houseimagedownload?img_name=<%=house.getName()%>" height="150px" width="200px" /></td>
</tr>
<%} %>
    
</body>
</html>
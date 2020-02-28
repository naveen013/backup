<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="nit.com.bo.House"%>
<%@page import="java.util.List"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Untitled Document</title>
</head>

<body bgcolor="gray">
<button type="button" ><a href="client_login_view1.jsp"><h5><----Back</h5></a></button>
 <%
        Object obj = request.getAttribute("houselist");
       List<House>list = (List<House>)obj;
      
     %>
    <h1 align="center">total house = <%=list.size() %></h1>
<table border="1px" cellpadding="0" cellspacing="0px"  width="90%" align="center">
<tr height="50px" align="center">
<td width="200px"><b></>NAME</b></td>
<td width="200px"><b></>LOCATION</b></td>
<td width="200px"><b></>CATEGORY</b></td>
<td width="200px"><b></>BEDROOM</b></td>
<td width="200px"><b></>EMAIL</b></td>
<td width="200px"><b>MOBILE</b></td>
</tr>
<%
for(House h1:list){%>
<tr align="center">
<td><%=h1.getName()%></td>
<td><%=h1.getLocation()%></td>
<td><%=h1.getCategory()%></td>
<td><%=h1.getBedroom()%></td>
<td><%=h1.getEmail()%></td>
<td><%=h1.getMobile()%></td>

<td ><img src="houseimagedownload?img_name=<%=h1.getName()%>" height="150px" width="200px" /></td>
<td>
    <a href="deletehouse?name=<%=h1.getName() %>">Delete house</a>
</td>
</tr>
<%} %>
</table>

</body>
</html>

<%@ include file="Header.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String msg = (String)session.getAttribute("lapreq");
%>
<div style="height:300px; background-color:lightblue;">
<center><h2>Rquest Status:</h2></center>
<center>
<table>
<td></td><td><h3><%=msg %></h3></td>
</tr>
</table>
</center>

</div>
</body>
</html>
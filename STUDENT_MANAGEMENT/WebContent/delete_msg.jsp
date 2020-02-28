<%@include file="header.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
   <%
Object obj   = request.getAttribute("del_msg");
%>
Delete message  <%=obj%><br>
<hr><br>
<a href="student">back to student show view </a>
</body>
</html>
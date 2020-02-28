<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
   <%
   Object obj = request.getAttribute("not_found_msg");
   %>
     <%if(obj!=null){%>
     <h1>NOT FOUND MSG :  <%=obj %></h1>
<%} %>

 <%@include file="stu_search_form.jsp" %>
</body>
</html>
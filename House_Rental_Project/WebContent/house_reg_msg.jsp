<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<title>Insert title here</title>
</head>
<body bgcolor="pink">
     <a href="home.jsp"><h4><b><-Back_To_Home</b></h4></a>
  <%
      Object obj = request.getAttribute("message");
    %>
     <h1 align="center"><b>Update message  <%=obj%></b></h1>

</body>
</html>
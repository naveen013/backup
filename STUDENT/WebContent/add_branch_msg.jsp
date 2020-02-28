<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
    <%
      Object obj = request.getAttribute("insert_message");
    %>
     <b>Update message  <%=obj%></b>
</body>
</html>
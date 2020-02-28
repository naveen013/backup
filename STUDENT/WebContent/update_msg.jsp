<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
    <%
       Object obj = request.getAttribute("update msg");
    %>
       Update message  <%=obj%>
       <a href="showstudent">back to student show view </a>
</body>
</html>
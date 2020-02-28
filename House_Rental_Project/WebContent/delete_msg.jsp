<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
</head>
<body>
   <%
Object obj   = request.getAttribute("del_msg");
%>
Delete message  <%=obj%><br>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
</head>
<body>
   <%

Object obj   = request.getAttribute("insert_msg");
%>
Update message  <%=obj%>
<hr>
<a href="stu">back to emp show view </a>
</body>
</html>